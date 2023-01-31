package com.learning.scala.chapter5.higher.order.functions

object Chapter5Content_07_PartialFunctions {
  def main(args: Array[String]): Unit = {
    //Function limiting input to a subset
    val lower: (Int, Int) => (Int, Int) = {
      case (a, b) if a < b => (-1, -1)
    }

    //This is fail
    //println(lower(10, 9))

    val pfLower: PartialFunction[(Int, Int), (Int, Int)] = {
      case (a, b) if a < b => (-1, -1)
    }

    val pfGreater: PartialFunction[(Int, Int), (Int, Int)] = {
      case (a, b) if a > b => (1, 1)
    }

    val pf = pfLower orElse pfGreater

    //The else function will run
    println(pf(10, 9))

    //This will fail, there is no partial function to handle equality
    println(pf(0, 0))
  }

}
