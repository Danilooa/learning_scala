package com.learning.scala.chapter4.functions

import scala.language.postfixOps

object Chapter4Exercise_03_5To50FiveTimes {

  def fiveTo50FiveTimes(): Unit = {
    val numbers = 5 to 50 toList;

    @annotation.tailrec
    def print5Times(numbers: List[Int]): Unit = {
      numbers match {
        case Nil => print("\n")
        case head :: tail =>
          print(s"\n${(for (_ <- 1 to 5) yield (s"$head ")).mkString(" ")}")
          print5Times(tail)
      }
    }
    print5Times(numbers)
  }

  def main(args: Array[String]): Unit = {
    fiveTo50FiveTimes()
  }

}
