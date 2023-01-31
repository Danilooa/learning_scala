package com.learning.scala.chapter5.higher.order.functions

object Chapter5Content_06_NamedParameters {
  def main(args: Array[String]): Unit = {

    def calculateOnlyPositiveNumber(number1: Double,
                                    byNameParameter1: => Double,
                                    byNameParameter2: => Double): (Double, Double) = {
      println("Calculating ...")
      byNameParameter1
      byNameParameter1
      (number1 >= 0, byNameParameter1 >= 0) match {
        case (true, true) => (byNameParameter2, byNameParameter2)
        case _ => (byNameParameter2, 0)
      }

    }

    def add(x: Double)(y: Double): Double = {
      println("Calling add")
      x + y
    }

    val alwaysAddTen = add(10) (_)

    println(calculateOnlyPositiveNumber(1, 2, alwaysAddTen(5)))

    println(calculateOnlyPositiveNumber(1, alwaysAddTen(4), alwaysAddTen(5)))

  }
}
