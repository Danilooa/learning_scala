package com.learning.scala.chapter5.higher.order.functions

object Chapter5Exercise_06_ConditionalTypes {
  def main(args: Array[String]): Unit = {

    def conditional[A](x: A, p: A => Boolean, f: A => A): A = {
      p(x) match {
        case true => f(x)
        case _ => x
      }
    }
  }
}
