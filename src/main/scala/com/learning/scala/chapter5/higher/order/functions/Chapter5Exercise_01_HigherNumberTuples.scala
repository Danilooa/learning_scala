package com.learning.scala.chapter5.higher.order.functions

object Chapter5Exercise_01_HigherNumberTuples {
  def main(args: Array[String]): Unit = {

    val max: (Int, Int) => Int = (a: Int, b: Int) => {
      (a > b) match {
        case true => a
        case _ => b
      }
    }

    def tuplesHighNumber(t1: (Int, Int),
                         t2: (Int, Int),
                         t3: (Int, Int),
                         maxParameter: (Int, Int) => Int): (Int, Int, Int) = {
      (maxParameter(t1._1, t1._2), maxParameter(t2._1, t2._2), maxParameter(t3._1, t3._1))
    }

    println(tuplesHighNumber((2, 3), (4, 6), (9, 7), max))
  }
}
