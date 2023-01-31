package com.learning.scala.chapter7.more.collections

import scala.language.postfixOps
import scala.util.Random

sealed abstract class Position(id: Int, name: String)

object Position {
  case object None extends Position(-1, "")

  case object Programmer extends Position(1, "Programmer")

  case object SystemAnalyst extends Position(2, "System Analyst")

  val all = IndexedSeq(Programmer, SystemAnalyst)

  def byIndex(index: Int): Position = {
    if (index == null) return Position.None
    if (index < 0 || index > all.size - 1) return Position.None
    all(index)
  }
}

case class Customer(id: Int, name: String, position: Position)

object Customer {

  private val source = 1 to 100 toList

  private val names = IndexedSeq("Arthur", "Jones", "Philip", "August", "Manson", "Simmons", "Stanley", "Lennon")

  private val sourceCustomer = source.map(i => {
    val namesIndexes = (
      Random.between(0, names.size),
      Random.between(0, names.size),
      Random.between(0, names.size)
    )
    val name = s"${names(namesIndexes._1)} ${names(namesIndexes._2)} ${names(namesIndexes._3)}"
    val position = Position.byIndex(Random.between(0, 2))
    Customer(i, name, position)
  })

  def allUsers: List[Customer] = sourceCustomer
}
