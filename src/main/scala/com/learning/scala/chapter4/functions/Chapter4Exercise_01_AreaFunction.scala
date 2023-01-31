package com.learning.scala.chapter4.functions

object Chapter4Exercise_01_AreaFunction {

  def area(radious: Double): Double = {
    Math.PI * Math.pow(radious, 2)
  }

  def main(args: Array[String]): Unit = {
    println(f"${area(8)}%.2f")
  }

}
