package com.learning.scala.chapter10.advancedtyping

class A

class B extends A

class C extends B

class Upper[T <: B](parameter: T) {
  def doesSomething(): T = parameter
}

class Lower[T >: B](parameter: T) {
  def doesSomething(): T = parameter
}

object Chapter10Content_04_BoundedTypes {

  def main(args: Array[String]): Unit = {
    //Works
    val upperSuccess = new Upper(new C)
    //Fail
    //val upperError = new Upper(new A)
    //Works
    val lowerSuccess = new Lower(new A)
    //Fail
    //val lowerError = new Lower(new C)

  }

}

