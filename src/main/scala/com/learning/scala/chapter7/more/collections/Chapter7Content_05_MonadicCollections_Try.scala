package com.learning.scala.chapter7.more.collections


import scala.language.postfixOps
import scala.util.{Failure, Random, Success, Try}

object Chapter7Content_05_MonadicCollections_Try {

  def main(args: Array[String]): Unit = {
    def mayThrowAnError(number: Int): Try[Int] = {
      Try(number / Random.nextInt(5))
    }

    def onlySuccess(number: Int): Try[Int] = {
      Try(number / 1)
    }

    val values = 1 to 10 toList

    println("----------- Init -------------")

    val possibleErrors = values.map(mayThrowAnError(_))
    println(possibleErrors.mkString("\n"))

    println("----------- flatMap -------------")
    //flatMap will map the result to a new Try in case of a success or by pass the fail
    val possibleFlattenErrors = possibleErrors.map(x => x.flatMap(onlySuccess))
    println(possibleFlattenErrors.mkString("\n"))

    println("----------- orElse -------------")
    //flatMap will map the result to a new Try in case of a success or by pass the fail
    val possibleOrElseErrors = possibleErrors.map(x => x.orElse(Try(100/2)))
    println(possibleOrElseErrors.mkString("\n"))

    println("----------- foreach -------------")
    //Execute the function in case of success or doesn't nothing in case of fail
    possibleErrors.foreach(_.foreach(println(_)))

    println("----------- map -------------")

    //Maps the try itself and not the result
    val value = possibleErrors.map(x => x.getOrElse(0))

    println(value.mkString("\n"))

    val i:Int = 0

  }
}
