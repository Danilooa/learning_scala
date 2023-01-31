package com.learning.scala.chapter5.higher.order.functions

object Chapter5Content_02_HighOrderFunctions {
  def main(args: Array[String]): Unit = {

    def add(number1: Double, number2: Double): Double = number1 + number2

    def multiple(number1: Double, number2: Double): Double = number1 * number2

    def calculateOnlyPositiveNumber(number1: Double,
                                    number2: Double,
                                    operation: (Double, Double) => Double): (Boolean, Double) = {

      (number1 >= 0, number2 >= 0) match {
        case (true, true) => (true, operation(number1, number2))
        case _ => (false, 0)
      }

    }

    System.out.println(calculateOnlyPositiveNumber(-10, 99, add))
    System.out.println(calculateOnlyPositiveNumber(10, 99, add))

    System.out.println(calculateOnlyPositiveNumber(-10, 99, multiple))
    System.out.println(calculateOnlyPositiveNumber(10, 99, multiple))

  }
}
