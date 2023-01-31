package com.learning.scala.chapter9ObjectsCaseClassesTraits

object Adder {
  def apply(numbers: List[Int]): Int = {
    numbers.reduce(_ + _)
  }

  def doSomethings[A, B](parameter1: A, parameter2: B): String = {
    ""
  }
}

object Chapter9Content_01_ApplyMethodCompanionObjects {
  def main(args: Array[String]): Unit = {
    println("Apply method, running methods using just the object name: " + Adder(List(10, 11, 33)))
  }
}
