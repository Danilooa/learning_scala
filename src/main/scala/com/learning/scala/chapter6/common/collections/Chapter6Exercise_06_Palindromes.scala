package com.learning.scala.chapter6.common.collections

object Chapter6Exercise_06_Palindromes {

  def matchPalindromes(strings: List[String], result: (List[String], List[String]) = (Nil, Nil)): (List[String], List[String]) = {
    strings match {
      case Nil => result
      case h :: t if (h == h.reverse) => matchPalindromes(t, (h :: result._1, result._2))
      case h :: t => matchPalindromes(t, (result._1, h :: result._2))
    }
  }

  def partitionPalindromes(strings: List[String]): (List[String], List[String]) = {
    strings partition (s => s.reverse == s)
  }

  def reducePalindromes(strings: List[String]): (List[String], List[String]) = {
    val leftInit = (List[String](), List[String]())
    strings.foldLeft(leftInit)((p, c) => {
      if (c == c.reverse) (c :: p._1, p._2) else (p._1, c :: p._2)
    })
  }

  def main(args: Array[String]): Unit = {
    val input = List("Hi", "otto", "yo", "racecar")
    println(matchPalindromes(input))
    println(partitionPalindromes(input))
    println(reducePalindromes(input))
  }
}
