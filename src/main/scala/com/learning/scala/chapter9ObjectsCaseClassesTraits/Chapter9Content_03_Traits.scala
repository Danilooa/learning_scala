package com.learning.scala.chapter9ObjectsCaseClassesTraits

object Chapter9Content_03_Traits {

  trait Addable {
    def always2: Int = 2

    def number1: Int

    def number2: Int
  }

  class FiveAdder extends Addable {
    override def number1: Int = 5

    override def number2: Int = 5
  }

  def add(addable1: Addable, addable2: Addable) : Int = {
    val sum1 = addable1.number1 + addable1.number2 + addable1.always2
    val sum2 = addable2.number1 + addable2.number2 + addable2.always2
    sum1 + sum2
  }

  def main(args: Array[String]): Unit = {
    println(add(new FiveAdder(), new FiveAdder()))
  }
}
