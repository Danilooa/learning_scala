package com.learning.scala.chapter5.higher.order.functions

object Chapter5Content_03_FunctionLiterals {
  def main(args: Array[String]): Unit = {

    def calculateOnlyPositiveNumber(number1: Double,
                                    number2: Double,
                                    operation: (Double, Double) => Double): (Boolean, Double) = {

      (number1 >= 0, number2 >= 0) match {
        case (true, true) => (true, operation(number1, number2))
        case _ => (false, 0)
      }

    }


    // Calling a higher order function passing a literal function
    System.out.println(s"Runs using the anonymous function: ${
      calculateOnlyPositiveNumber(-10, 99, (a: Double, b: Double) => {
        a / b
      })
    }");

    // Defining an anonymous function
    System.out.println(s"Prints the literal function variable: ${ (a: Double, b: Double) => {
      a / b
    }
    }")

    // Defining a literal function
    val minusAsLiteral = (a: Double, b: Double) => {
      a / b
    }
    System.out.println("Runs using the literal function: " + calculateOnlyPositiveNumber(-10, 99, minusAsLiteral))

  }
}
