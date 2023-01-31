package com.learning.scala.chapter5.higher.order.functions

object Chapter5Content_04_PlaceholderSyntax {
  def main(args: Array[String]): Unit = {


    /*
    The placeholders(_) will replace the parameters in the order they appear
    In this examples the third parameter is the function (Int, Int) => Int
    then the first appearance of _ will be same of the first parameter, the second the second parameter and so on.
    Considering that, the maximum number of placeholder must be equal or less the number of parameters
     */
    def function(d1: Int, d2: Int, f1: (Int, Int) => Int): String = {
      "f1: " + f1(d1, d2)
    }

    println(function(1, 2, _ * _))
  }
}
