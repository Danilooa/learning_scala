package com.learning.scala.chapter5.higher.order.functions

object Chapter5Content_01_FunctionTypesAndValues {
  def main(args: Array[String]): Unit = {

    def double(x: Int): Int = x * 2

    val myDouble: (Int) => Int = double

    val myDouble2 = double _

    println(myDouble(5))

    val myDoubleCopy = myDouble

    println(myDoubleCopy(7))
  }
}
