package com.learning.scala.chapter7.more.collections


import scala.language.postfixOps
import scala.util.{Failure, Random, Success, Try}

object Chapter7Content_05_MonadicCollections {

  def main(args: Array[String]): Unit = {
    //    val x = 0
    //    val someZero = Option(x)
    //    println(someZero)
    //
    //    val y = null
    //    val noneZero = Option(y)
    //    println(noneZero)
    //
    //    println("Is someZero empty? " + someZero.isEmpty)
    //    println("Is someZero empty? " + someZero.isDefined)
    //
    //    println("Is noneZero empty? " + noneZero.isEmpty)
    //    println("Is noneZero empty? " + noneZero.isDefined)
    //
    //
    //    val numberLowerThanFive = List(1, 2, 3, 4)
    //    val noneCollection = numberLowerThanFive.filter(_ > 5).map(_ + "2")
    //
    //    //Since head doesn't check for empty collections it will fail
    //    val headFailed = Try(noneCollection.head) match {
    //      case Success(value) => (true, value)
    //      case Failure(exception) => (false, exception.getMessage)
    //    }
    //
    //    println(headFailed)
    //
    //    //Since head doesn't check for empty collections it will fail
    //    val headSucceeded = Try(noneCollection.headOption) match {
    //      case Success(value) => (true, value.getOrElse("Will always succeed"))
    //      case Failure(_) => (false, "will never fail")
    //    }
    //
    //    println(headSucceeded)
    //
    //    //Will return none since find is a combination of filter and headOption
    //    val maybeCollection = numberLowerThanFive.find(_ > 5).map(_ + "2")
    //    println(maybeCollection)
    //
    def divide(number1: Int, number2: Int): Option[Int] = {
      if (number2 == 0) return None
      Some(number1 / number2)
      Some(0)
    }

    val attempt1 = divide(2, 2)

    val maybeInt = attempt1.flatMap(a => divide(1, a))

    println(maybeInt)

  }
}
