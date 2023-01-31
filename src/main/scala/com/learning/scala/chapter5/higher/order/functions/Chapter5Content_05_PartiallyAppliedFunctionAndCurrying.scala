package com.learning.scala.chapter5.higher.order.functions

object Chapter5Content_05_PartiallyAppliedFunctionAndCurrying {
  def main(args: Array[String]): Unit = {
    def multiply(x: Int)(y: Int)(z: Int) = x * y - z

    val multiplyBy10 = multiply(10)(_: Int)(_: Int)

    println(multiplyBy10(11, 12))

    //Literal currying
    val intToIntToIntToInt: Int => Int => Int => Int = (a: Int) => {
      (b: Int) => {
        (c: Int) => {
          a + b + c
        }
      }
    }

    println("literal: " + intToIntToIntToInt(1)(2)(3))


    //def defIntToIntToIntToInt(
    // (a: Int): (Int => (Int => Int))) = {
    def defIntToIntToIntToInt(a: Int): Int => Int => Int = {
      def bf(b: Int): Int => Int = {
        def cf(c: Int): Int = {
          a + b + c
        }

        cf
      }

      bf
    }

    println("def: " + defIntToIntToIntToInt(1)(2)(3))


    def bhaskara(a: Double): Double => Double => Double = {
      val fourTimesA = - 1 * 4 * a
      val twiceA = a * 2
      def functionB(b: Double): Double => Double = {
        val minusB = b * - 1
        val bPow2 = b * b
        def functionC(c: Double): Double = {
          val squareRoot = Math.sqrt(bPow2 - (fourTimesA * c))
          (minusB - squareRoot) / twiceA
        }
        functionC
      }
      functionB
    }

    println("bhaskara: " + bhaskara(2)(2)(2))
  }
}