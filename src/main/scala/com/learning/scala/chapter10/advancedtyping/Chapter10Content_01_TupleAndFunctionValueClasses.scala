package com.learning.scala.chapter10.advancedtyping

object Chapter10Content_01_TupleAndFunctionValueClasses {

  def main(args: Array[String]): Unit = {
    val add = new Function1[Int, Int]() {
      override def apply(v1: Int): Int = {
        v1 + v1
      }
    }


    val multiple: Int => Int = (a: Int) => {
      a * a
    }

    //val multiple = Int => Int =
    val result:Int = add.andThen(multiple)(3)
    println(result)
  }
}
