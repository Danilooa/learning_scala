package com.learning.scala.chapter6.common.collections

import scala.language.postfixOps

object Chapter6Content_02_List {
  def main(args: Array[String]): Unit = {

    //Creating lists
    val list1 = List(1, 2, 3)
    val list2 = List("A", "B")

    //Accessing elements
    val one = list1(1)

    val zeroToTen = 0 to 10 toList

    //Prints 0
    println(zeroToTen.head)

    //Prints List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(zeroToTen.tail)

    //Each element os a list has its own head and tail
    var headAndTail = 5 to 10 toList

    while (! headAndTail.isEmpty) {
      println("--------------------------------")
      println("head: " + headAndTail.head + ", ")
      headAndTail = headAndTail.tail
      println("tail: " + headAndTail + ", ")
    }

    //Using Nil to check the end of a list
    headAndTail = 5 to 10 toList

    while (headAndTail != Nil) {
      println("--------------------------------")
      println("head: " + headAndTail.head + ", ")
      headAndTail = headAndTail.tail
      println("tail: " + headAndTail + ", ")
    }

    BigDecimal(0)+BigDecimal(3)
  }
}
