package com.learning.scala.chapter6.common.collections

import java.time.LocalDateTime
import scala.language.postfixOps
import scala.xml.{PrettyPrinter, XML}

object Chapter6Exercise_07_OpenWeatherApi {

  def main(args: Array[String]): Unit = {
    val apiKey = "b425f20457192208b54f2ad1e6d520bb"
    val url = s"https://api.openweathermap.org/data/2.5/forecast?mode=xml&lat=55&lon=0&appid=$apiKey"
    val prettyPrinter = new PrettyPrinter(Int.MaxValue, 4)
    val response = prettyPrinter
      .format(XML.loadString(io.Source.fromURL(url).mkString))
      .split("\n")

    val firstTen = response.take(10)

    val cityRegex = """(.*<name>)(.*)(<\/name>)""".r
    val countryRegex = """(.*<country>)(.*)(<\/country>)""".r

    def findCityCountry(p: (String, String), c: String): (String, String) = {
      c match {
        case cityRegex(_, city, _) => (city, p._2)
        case countryRegex(_, country, _) => (p._1, country)
        case _ => p
      }
    }

    val cityCountry = firstTen.foldLeft(("", ""))(findCityCountry(_, _))
    println(s"\nCity: $cityCountry")

    val timeRegex = """(.*<time from=")(.*)(" to=")(.*)(">)""".r
    val symbolRegex = """(.*<symbol number=")(.*)(" name=")(.*)(" var=")(.*)("\/>)""".r

    case class Time(from: String = "",
                    to: String = "",
                    number: Int = Int.MinValue,
                    name: String = "",
                    variable: String = "")

    val forecastElements = response.foldLeft(List[Time]())((p, c) => {
      c match {
        case timeRegex(_, from, _, to, _) =>
          Time(from = from, to = to) :: p
        case symbolRegex(_, number, _, name, _, variable, _) =>
          p.head.copy(number = number.toInt, name = name, variable = variable) :: p.tail
        case _ => p
      }

    })
    println(s"\nInformal weather report:\n${forecastElements.take(5).mkString("\n")}")

    val descriptions = forecastElements.foldLeft(Set[String]())((p, c) => p + c.name).toList.sorted
    println(s"\nDescriptions:\n${descriptions.mkString("\n")}")
    //<symbol number="500" name="light rain" var="10d"/>
    println(response.mkString("\n"))
  }

}
