# TODO
Ranges<br>
Seq x List<br>
sbt<br>
unapply

# Learning Scala

## Variable types

### [Numeric types declared without decimal separators will be treated as integers](./src/main/scala/com/learning/scala/chapter2/data/literals/variables/types/Chapter2Exercise_1_2_CentigradeToFahrenheit.scala)

### [Regex matching groups could be directly assigned to variable](./src/main/scala/com/learning/scala/chapter2/data/literals/variables/types/Chapter2Exercise_6_MatchingRegularExpressions.scala)

## Functions

### What is a pure function ?
* Has one or more input parameters
* Performs calculations using only the input parameters
* Returns a value 
* Always returns the same value for the same input
* Does not use or affect any data outside the function
* Is not affected by any data outside the function

### [Functions with only one parameter could be call passing an expressing block](./src/main/scala/com/learning/scala/functions/Chapter4Content_3_FunctionInvocationWithExpressionBlocks.scala)

### [Allow recursive functions optimization using tail-recursion](./src/main/scala/com/learning/scala/functions/Chapter4Content_3_FunctionInvocationWithExpressionBlocks.scala)
<p>To prevent this scenario, the Scala compiler can optimize some recursive functions with
tail-recursion so that recursive calls do not use additional stack space. With tail-recursion–optimized functions,
recursive invocation doesn’t create new stack space but
instead uses the current function’s stack space. Only functions whose last statement is
the recursive invocation can be optimized for tail-recursion by the Scala compiler. If the
result of invoking itself is used for anything but the direct return value, a function can’t
be optimized.</p>

### [Nested functions example](./src/main/scala/com/learning/scala/functions/Chapter4Content_5_NestedFunctions.scala)

### [Type Parameters Inference]()
<p>The compiler could infer the type from either the
String literal we passed it or the String value to which we assigned the function’s return
value.</p>

### Operator notation
<p><strong>any.doesSomething(10)</strong> 
is the same as
<strong>any doesSomething 10</strong></p>

### What is a first class function ? 
They can be:

* used in every segment of the language as just another data type
* created in literal form without ever having been assigned an identifier
* stored in a container such as a value, variable, or data structure
* used as a parameter to another function 
* used as the return value from another function

### What is a higher order function ?
Functions that accept other functions as parameters and/or use functions as return values.

### [Assigning function to variables](./src/main/scala/com/learning/scala/chapter5/higher/order/functions/Chapter5Content_01_FunctionTypesAndValues.scala)
```
def multiple(par1: Int, par2: Int) : Int =  par1 * par2
```
Defining the variable types:
```
val typedMultipleCopy(Int, Int) => Int = multiple 
```

Using the Wildcard _ :
```
val wildCardMultipleCopy: multiple _
```

### [Higher order function](./src/main/scala/com/learning/scala/chapter5/higher/order/functions/Chapter5Content_02_HighOrderFunctions.scala)

Currying is a function that takes one argument at a time and returns a new function expecting the next argument.
<br>
It is a transformation of functions that translates a function from callable as f(a, b, c) into callable as f(a)(b)(c).

### [Literal functions](./src/main/scala/com/learning/scala/chapter5/higher/order/functions/Chapter5Content_03_FunctionLiterals.scala)

A working function that lacks a name, and assign it to a new function value

### [Placeholder syntax](./src/main/scala/com/learning/scala/chapter5/higher/order/functions/Chapter5Content_04_PlaceholderSyntax.scala)

The placeholders(_) will replace the parameters in the order they appear
<br>
In this example the literal function is (Int, Int) => Int
<br>
then the first appearance of _ will be same of the first parameter,
<br>
the second appearance will be same as the second parameter and so on.
<br>
Considering that, the maximum number of placeholder must be equal or less the number of parameters.

```
def function(d1: Int, d2: Int, f1: (Int, Int) => Int): String = {
  "f1: " + f1(d1, d2)
}

println(function(1, 2, _ * _))
```

### [Partially Applied Functions and Currying](./src/main/scala/com/learning/scala/chapter5/higher/order/functions/Chapter5Content_05_PartiallyAppliedFunctionAndCurrying.scala)

### [What is a by - name parameter?](./src/main/scala/com/learning/scala/chapter5/higher/order/functions/Chapter5Content_06_NamedParameters.scala)

```
<identifier>: => <type>
```

It allows to pass a value or a function to a parameter, if a function is passed it will be invoked each time the parameter is called.

### [Currying a function](src/main/scala/com/learning/scala/chapter5/higher/order/functions/Chapter5Content_05_PartiallyAppliedFunctionAndCurrying.scala)

Currying is a function that takes one argument at a time and returns a new function expecting the next argument.
<br>
It is a transformation of functions that translates a function from callable as f(a, b, c) into callable as f(a)(b)(c).

### [What is a partial function?](./src/main/scala/com/learning/scala/chapter5/higher/order/functions/Chapter5Content_07_PartialFunctions.scala)

There are some functions that do not support every possible value that meets<br>
the input types. For example, a function that returns the square root of the input number
<br>
would certainly not work if the input number was negative. Likewise, a function that
<br>
divides by a given number isn’t applicable if that number is zero. Such functions are
<br>
called partial functions because they can only partially apply to their input data.
<br>
[Here](https://alvinalexander.com/scala/how-to-define-use-partial-functions-in-scala-syntax-examples/) you can find great uses of partial functions.


## Collections

### [List](src/main/scala/com/learning/scala/chapter6/common/collections/Chapter6Content_02_List.scala)

#### Why not to use the method .size ?

Because linked lists, the size method would have to traverse to the end of the list each time.<br>
Fortunately, there is an isEmpty method on lists we can use that does not need to traverse the list.

#### Nil

* Nil is essentially a singleton instance of List[Nothing].<br>
* The Nothing type is a noninstantiable subtype of all other Scala types.<br>
* A list of Nothing types is thus compatible with lists of all other types and can be safely used as their terminus.<br>
* Creating a new, empty list will actually return Nil instead of a fresh instance.<br>
* Because Nil is immutable, there is essentially no difference between it and a fresh, empty list instance.<br>
* Likewise, creating a new list that has a single entry just creates a single list element that points to Nil as its tail.

#### Left associative operator

The most usual, the left element invokes an operation taking the right elements as arguments.<br>
Example:<br>

```
// 0 adds 3 to itself

BigDecimal(0) + BigDecimal(3)

//Same as

BigDecimal(0).add(BigDecimal(3))
```

#### Right associative operator

The right element invokes an operation taking the left elements as arguments.

```
// Nil adds 3 to itself and so on

val numbers = 1 :: 2 :: 3 :: Nil

```
#### Cos operator ::

There is an alternate way to construct lists that takes advantage of this relationship with Nil.<br>
As another nod to Lisp, Scala supports use of the cons (short for construct) operator to build lists.<br>
Using Nil as a foundation and the right-associative cons operator :: for binding elements,<br>
you can build a list without using the traditional List(...) format.

```
scala> val first = Nil.::(1)
first: List[Int] = List(1)

scala> first.tail == Nil
res3: Boolean = true

scala> val second = 2 :: first
second: List[Int] = List(2, 1)

scala> second.tail == first
res4: Boolean = true

```

#### Why is it better to act on the front of lists and prefer operator notation ?

Recall that List is a linked list,<br>
so adding items to or removing items from its front does not require a full traversal.<br>
A list traversal is a trivial operation for short lists,<br>
but when you start getting into lists of thousands or millions of items,<br>
an operation that requires a list traversal can be a big deal.<br>
That said, these operations have corollary operations that act on the end of the list and thus do require a full list traversal.<br>
Additionally, because adding items to the end of a list would mutate it,<br>
they require copying the entire list and returning the copy.<br>
Again, not an important memory consideration unless you are working with large lists,<br>
but in general it is best to operate on the front of a list, not its end.

#### Arithmetic operations on lists

::<br>
Appends individual elements to this list.<br>
A right-associative operator.<br>

:::<br>
Prepends another list to this one.<br>
A right-associative operator.<br>

++<br>
Appends another collection to this list.<br>

==<br>
Returns true if the collection types and contents are equal.<br>

distinct<br>
Returns a version of the list without duplicate elements.<br>

drop<br>
Subtracts the first n elements from the list.<br>

filter<br>
Returns elements from the list that pass a true/false function.<br>

flatten<br>
Converts a list of lists into a single list of elements.<br>

partition<br>
Groups elements into a tuple of two lists based on the result of a true/false function.

reverse<br>
Reverses the list.<br>

slice<br>
Returns a segment of the list from the first index up to but not including the second index.<br>

sortBy<br>
Orders the list by the value returned from the given function.<br>

sorted<br>
Orders a list of core Scala types by their natural value.<br>

splitAt<br>
Groups elements into a tuple of two lists based on if they fall before or after the given index.<br>

take<br>
Extracts the first n elements from the list.<br>

zip<br>
Combines two lists into a list of tuples of elements at each index.<br>

#### Mapping operations

collect<br>
Transforms each element using a partial function, retaining applicable elements.<br>

flatMap<br>
Transforms each element using the given function and “flattens” the list of results into this list.

map<br>
Transforms each element using the given function.<br>

#### What is fold ?

A fold is a way of getting a single value by operating on a list of values. Same as reduction.

#### Infix operator

The ability to call a function without the (.) dot before it and if the function takes none or one parameter
ignoring the parentheses. Example:

```
val validations = List(true, true, false, true, true, true)
val valid2 = validations forall (_ == true)
```

#### Math reduction operations

max<br>
Finds the maximum value in the list.<br>

min<br>
Finds the minimum value in the list.<br>

product<br>
Multiplies the numbers in the list.<br>

sum<br>
Sums up the numbers in the list.<br>


#### Boolean reduction operations

contains<br>
Checks if the list contains this element.<br>

endsWith<br>
Checks if the list ends with a given list.<br>

exists<br>
Checks if a predicate holds true for at least one element in the list.<br>

forall<br>
Checks if a predicate holds true for every element in the list.<br>

startsWith<br>
Tests whether the list starts with a given list.<br>

#### Generic list operations

##### Return one element
fold<br>
Reduces the list given a starting value and a reduction function.<br>

foldLeft<br>
Reduces the list from left to right given a starting value and a reduction function.<br>

foldRight<br>
Reduces the list from right to left given a starting value and a reduction function.<br>

reduce<br>
Reduces the list given a reduction function, starting with the first element in the list.<br>

reduceLeft<br>
Reduces the list from left to right given a reduction function, starting with the first element in the list.<br>

reduceRight<br>
Reduces the list from right to left given a reduction function, starting with the first element in the list.<br>

##### Return a list
scan<br>
Takes a starting value and a reduction function and returns a list of each accumulated value.<br>

scanLeft<br>
Takes a starting value and a reduction function and returns a list of each accumulated value from left to right.<br>

scanRight<br>
Takes a starting value and a reduction function and returns a list of each accumulated value from right to left.<br>

#### About the different types of reductions

The three folding operations, fold , reduce , and scan , are really not very different from each other.<br>

Fold , reduce , and scan are all limited to returning a value of the same type as the list elements<br>
while the left/right variations of each operation support unique return types.<br>
Thus you could implement the forall Boolean operation on a list of integers with foldLeft<br>
but would not be able to do so with fold.<br>

Unless you are specifically using distributed or parallel collections,<br>
or you are developing a library that may be reused with such collections,<br>
it is safe to simply choose the left/ right directional varieties.<br>
I will also recommend that, unless you require right-to-left iteration,<br>
it is better to select the “left” operations because they require fewer traversals through the list in their implementation.<br>


#### Operations to convert collections

As immutable collections, List, Map, and Set cannot be built from empty collections<br>
and so are better suited to being mapped from existing collections.<br>

mkString<br>
Renders a collection to a Set using the given delimiters.<br>

toBuffer<br>
Converts an immutable collection to a mutable one.<br>

toList<br>
Converts a collection to a List.<br>

toMap<br>
Converts a collection of 2-arity (length) tuples to a Map.<br>

toSet<br>
Converts a collection to a Set.<br>

toString<br>
Renders a collection to a String , including the collection’s type.<br>

### Java and Scala Collection Compatibility

Java and Scala collections are incompatible by default.<br>
To enable conversions between Java and Scala collections the following commands must be used:<br>

```
import collection.JavaConverters._
import collection.JavaConverters._
```

The to convert the collections are:

asJava<br>
Converts this Scala collection to a corresponding Java collection.<br>

asScala<br>
Converts this Java collection to a corresponding Scala collection.<br>

## Mutable collections

### Buffer

* General purpose<br><br>
* Drawback: may be too broadly applicable. <br>
* If all you need is to put together a collection iteratively, e.g., inside a loop,<br>
* a builder may be a good  choice instead.<br><br>
* Add, remove, and replace its contents<br><br>
* How to create? Immutable.toBuffer<br><br>
* How to convert? buffer.toList, toMap, toSet<br>

### Equivalents
collection.immutable.List -> collection.mutable.Buffer<br>
collection.immutable.Set  -> collection.mutable.Set<br>
collection.immutable.Map  -> collection.mutable.Map<br>

### Builder

* Supports only append operations;<br>
* How to create? [Set, List, Map].newBuilder;<br>
* How to convert? builder.result<br>

### Array

* Fixed size;<br>
* Are not scala collections;<br>
* Used to index collections;<br>
* Do not override toString then producing an unreadable output.

### Seq

Seq is the root type(Interface abstraction) of all sequences,<br>
including linked lists like List and indexed (direct- access) lists like Vector.

### Infinite collections

#### Stream

Don't use, it is deprecated.<br>

#### [Lazy List](src/main/scala/com/learning/scala/chapter7/more/collections/Chapter7Content_04_LazyList.scala)

A list with a dynamically defined size,<br>
it is generated using the operator #:: to append a tail generated by a recursive call.<br>
Eventually, the recursive call can return LazyList.empty instead another call then ending the collection.

### [Monadic collections](src/main/scala/com/learning/scala/chapter7/more/collections/Chapter7Content_05_MonadicCollections.scala)

#### Why to use monadic collection ?

Avoid nulls and consequently side effects<br>

#### Option

Can not be instantiated, is the root type of Some and None.<br>
On the other hand, the method Option(value) will result in a typed Some or a None<br>

#### None

Has no type.

#### isDefined, isEmpty

None returns: isDefined == false and isEmpty == true<br>
Some returns: isDefined == true and isEmpty == false<br> 

### [Parallel Collections](src/main/scala/com/scala/cookbook/parallel/collections/ParallelCollectionPerformanceTest.scala)

#### Add the dependency if necessary
```
libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4"
```

#### How they work ?
Conceptually, Scala's parallel collections framework parallelizes an operation on a parallel collection<br>
by recursively “splitting” a given collection, applying an operation on each partition of the collection in parallel,<br>
and re-“combining” all the results that were completed in parallel.

### Views

The View is a special kind of collection in Scala<br>
that takes a base collection and executes transformer methods on that collection lazily.<br>
We can turn every Scala collection into a lazy representation and back via the view method.<br>
They are suitable to operate huge collections without overwhelming the memory. This is possible because the elements<br>
are loaded by demand (non-strict, lazily) avoiding loading all the elements in the memory all at once(strict mode).

### [Try](src/main/scala/com/learning/scala/chapter7/more/collections/Chapter7Content_05_MonadicCollections_Try.scala)

#### flatMap

Maps the successful result to new Tries or by pass the failures.

#### foreach

Iterate only over the successful results

#### orElse

By pass the success tries and map failures to new chosen tries

#### Collection.headOption

Same as head but doesn't fail since it always returns an optional value<br>

#### Collection.find

Same as using Collection.filter followed by Collection.headOption.<br>
Thus, never returning an error while searching for the first element, head, of a list.

#### Useful monadic functions

fold<br>
Returns the value from the given function for Some (in this case, based on the embedded value) or else the starting value.<br>
The foldLeft, foldRight, and reduceXXX methods are also available for reducing an Option down to its embedded value or else a computed value.<br>

getOrElse<br>
Returns the value for Some or else the result of a by-name parameter.<br>

orElse<br>
Doesn't actually extract the value, but attempts to fill in a value for None.<br>
Returns this Option if it is nonempty, otherwise returns an Option from the given by-name parameter.<br>

Match expressions<br>
Use a match expression to handle the value if present.<br>
The Some(x) expression extracts its data into the named value “x”,<br>
which can be used as the return value of the match expression or reused for further transformation.<br>

### [Future](src/main/scala/com/learning/scala/chapter7/more/collections/Chapter7Content_05_MonadicCollections_Future.scala)

flatMap<br>
Nests futures sometime in the future. It is a not blocking operation then will not run<br>
immediately after its declaration.

map<br>
Takes the result of a future and maps it sometime in the future. It is a not blocking operation then will not run<br>
immediately after its declaration.

### Object

* Works as a singleton;<br>
* Provides methods in static and global manners;<br>
* Objects are lazily initialize when they are first accessed;<br>
* Apply methods make it possible to call methods straight from the class name<br>
* Code written directly on the body of an object, outside a function, will run only when the object is created;</br>
* Cannot take class parameters;<br>

### Case classes

Good for immutable value objects;

### Traits

* Enables multiple inheritance;<br>
* Cannot be instantiated;<br>
* They differ from Java interfaces because they can implement methods. Then, when they are extended, instead of
* forcing methods implementations they add behaviour to the classes;<br>
* A classes or ever another trait can extend many traits;<br>
* If a class extends many traits, the compiler will make the traits inherit each other, from the right to the left, in a linear way;<br>
* In a multiple inheritance when members of traits compete an exception will be thrown. To solve this,
the traits with competing members should inherit from a base class that declares the competing members, then they
must use the keyword override when implementing them;<br>

### Self types

Force traits to be inherited only from a specific type. Since traits can access members of its parents, using
self types will allow traits to access class parameters from its self type what is not possible to common traits.

### Importing Instance Members

```
case class Receipt(id: Int, amount: Double, who: String, title: String)

val latteReceipt = Receipt(123, 4.12, "fred", "Medium Latte")
import latteReceipt._
println(s"Sold a $title for $amount to $who")

out: Sold a Medium Latte for 4.12 to fred
```

### Tuples

* In reality, they are 22 classes with arities corresponding to the number that names the class<br>
* The parameters are generic typed and inferred at compilation time<br>

### Functions

* Literal and value functions are translated to classes<br>
* Are in reality classes similar to tuples but run through an apply method<br>
* Function with one parameter can be chained using the methods "compose" or "andThen"<br>

### Implicit parameters

* Define default values for a specific type inside a namespace<br>
* Parameters marked with the "implicit" keyword will search for implicit values from the current namespace<br>
* To make a val available to implicit parameters just mark a val with the "implicit" keyword

### [Implicit classes](src/main/scala/com/learning/scala/chapter10/advancedtyping/Chapter10Content_03_ImplicitClasses.scala)

* Enable types to call methods of another types;<br>
* The type that receives the method is passed as a parameter to the implicit class constructor;<br>
* The implicit class implements many methods;<br>
* Now the parameter type can run methods from the implicit class.<br>

### Type Aliases

Available

### Abstract Types

An upper class defines one or more type aliases for fields, parameters or methods.<br>
Since none concrete type is assign to the type aliases in the upper class the child classes must inform the concrete type.

### [Bounded Types](src/main/scala/com/learning/scala/chapter10/advancedtyping/Chapter10Content_04_BoundedTypes.scala)

Restricts to supertypes or subtypes.<br>

#### A:>B
Will allow only supertypes of B or B itself.

#### A:<B
Will allow only subtypes of B or B itself.
Does not work to restrict functions parameters and outputs works fine for classes definitions.

### [Type Variance](src/main/scala/com/learning/scala/chapter10/advancedtyping/Chapter10Content_04_TypeVariance.scala)

By default, a typed variable cannot receive a subtype instance, the fallowing example is not allowed:<br>

```
class A
class B extends A

class Item[B](parameter: B)

//It will fail to compile
val value: Item[A] = new Item[B](B)
```

####+Type

The operator "+" placed after the type in the class Item will solve this problem:

```
class A
class B extends A

class Item[B](parameter: B)

//It will fail to compile
val value: Item[A] = new Item[B](B)
```

####-Type

Parameters of a function cannot be covariant since it is impossible to predicted that a function will only use<br>
methods of a supertype, the - operator assures contravariant parameters:

```
//Fails to compile 
class Fails[+T]() {
    def doesSomething(parameter: T): T {
        parameter
    }

}

//Succeeds to compile 
class Succeeds[-T]() {
    def doesSomething(parameter: T): T {
        parameter
    }
}

// Athough leaving just the type without any variance will also succeed
class Succeeds[T]() {
    def doesSomething(parameter: T): T {
        parameter
    }
}

```

### Package objects

Type aliases, abstract types usually needs to be import or defined inside the current namespace to work.<br>
The use of package objects makes those features available to the whole package without the need of further imports.
