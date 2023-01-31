package com.learning.scala.chapter2.data.literals.variables.types

object Chapter2Exercise_5_DataConvertions {
  def main(args: Array[String]): Unit = {
    //128 is the empty '' character
    val from = 128

    val char = from.toChar
    println(s"char '${char}'")

    val string = char.toString
    println(s"char '${string}'")

    val double = string(0).toDouble
    println(s"double '${double}'")

    val int = double.toInt
    println(s"double '${int}'")

  }
}
