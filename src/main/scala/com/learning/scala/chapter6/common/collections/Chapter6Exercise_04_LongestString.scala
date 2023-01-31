package com.learning.scala.chapter6.common.collections

object Chapter6Exercise_04_LongestString {
  def main(args: Array[String]): Unit = {
    val strings = List("aaaaa", "bb", "ccc", "d")
    val longest = strings.foldLeft("")((p, c) => if (p.size > c.size) p else c)
    println(longest)

    def greatest[A](elements: List[A], max: (A, A) => A): A = {
      elements.reduce(max(_, _))
    }
    def longestString(p: String, c: String) = if (p.size > c.size) p else c
    println(greatest(strings, longestString))
  }
}
