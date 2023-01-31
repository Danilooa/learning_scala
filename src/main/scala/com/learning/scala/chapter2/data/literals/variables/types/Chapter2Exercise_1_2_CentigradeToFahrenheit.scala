package com.learning.scala.chapter2.data.literals.variables.types

object Chapter2Exercise_1_2_CentigradeToFahrenheit {
  def main(args: Array[String]): Unit = {
    val x = 7
    println(s"x type: ${x}, ${x.getClass}")

    /*
    If 5 is informed instead of 5.0 nineBy5 will be an Int
     */
    val nineBy5 = 9/5.0
    println(s"9/5: ${nineBy5}, ${nineBy5.getClass}")

    val xPlusNineBy5 = x * nineBy5
    println(s"xPlusNineBy5: ${xPlusNineBy5}, ${xPlusNineBy5.getClass}")

    val result = xPlusNineBy5 + 32
    println(s"result: ${result}, ${result.getClass}")

  }
}
