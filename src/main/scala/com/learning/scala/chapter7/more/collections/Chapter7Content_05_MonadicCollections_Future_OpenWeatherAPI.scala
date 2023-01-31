package com.learning.scala.chapter7.more.collections

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps


object Chapter7Content_05_MonadicCollections_Future_OpenWeatherAPI {

  def main(args: Array[String]): Unit = {
    val apiKey = "b425f20457192208b54f2ad1e6d520bb"

    def cityTemp(name: String): Double = {
      val url = "http://api.openweathermap.org/data/2.5/weather"
      val cityUrl = s"$url?q=$name&appid=$apiKey"
      val json = io.Source.fromURL(cityUrl).mkString.trim
      val pattern = """.*"temp":([\d.]+).*""".r
      val pattern(temp) = json
      temp.toDouble
    }

    //    val cityTempsRequests: Future[Seq[Double]] = Future sequence Seq(
    //      Future(cityTemp("Fresno")), Future(cityTemp("Tempe"))
    //    )

    val cityTempsRequests = Future(cityTemp("Fresno"))

    Thread.sleep(5000)

    def callback(temp: Any): Unit = {
      System.out.println(temp)
    }

    cityTempsRequests.map(callback(_))


    Thread.sleep(5)
  }

}
