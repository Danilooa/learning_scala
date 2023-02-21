package com.scala.cookbook.parallel.collections

import scala.collection.parallel.immutable.ParVector
import scala.util.Random

object ParallelCollectionPerformanceTest {

  def main(args: Array[String]): Unit = {
    val vector = ParVector.fill(100_000_000)(Random.nextLong())
    //val vector = Vector.fill(100_000_000)(Random.nextLong())
    val begin = System.currentTimeMillis()
    val smallestNumber = vector.reduce((a, b) => if (a < b) a else b)
    val end = System.currentTimeMillis()
    //Using parallel ParVector 27637
    //Using common Vector 37687
    println(s"Time spent: ${end - begin} $smallestNumber")
  }
}
