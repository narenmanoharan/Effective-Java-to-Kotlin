Item 23: Don't Use raw types in new code

A generic class is one which is_typesafe\_and has one or more type parameters in its declaration. Generic classes and interfaces are collectively known as\_generic types_. But in Kotlin, the compiler forces you to use parameterized type definitions or else it won't compile.

```kotlin
// Parameterized collection of Animals
val listOfAnimals: List<Animal> = listOf(Lion, Tiger, Wolf)
```

#### Benefits of using Generic and Parameterized types

* Produce \_typesafe \_code
* Warn during compile time rather than fail during runtime
* No manual casting when getting elements from collections.

```kotlin
// Attempt at a generic function using Any
fun random(one: Any, two: Any, three: Any): Any

// Using Type Parameter
 fun <T> random(one: T, two: T, three: T): T

// Called as such and infers that T is of type String
val randomGreeting: String = random("hello", "Willkommen", "bonjour")

// This would also compile since the compiler infers that T is of type Any. (The inferred type would be the lowest common supertype)
val any: Any = random("a", 1, false)

// Functions can have two type parameters as well
fun <K, V> put(key: K, value: V): Unit

// Parameterized Class
class Dictionary<K, V>
val dict = Dictionary<String, String>()
```

#### Bounded polymorphism

To limit the use of`Any`in generic usage, bounded polymorphism was introduced which helped restrict the actual parameters to being of the certain type. Kotlin supports upper bound polymorphism. As the name implies, an upper bound restricts the types to those that are subclasses of the bound. To use an upper bound,

```kotlin
fun <T : Comparable<T>> min(first: T, second: T): T {
    val k = first.compareTo(second)
    return if (k <= 0) first else second
}

// Legal since Int and String extend Comparable
val a: Int = min(4, 5)
val b: String = min("e", "c")
```

> Whenever a type parameter is used without an explicit upper bound, the compiler will use Any as an implicit upper bound for us.

#### Multiple Bounds

Using the`where`clause we can ensure that our function, class has multiple bounds. But we need to extend both the bounds for this to work.

```kotlin
fun <T> minSerializable(first: T, second: T): T where T : Comparable<T>, T : Serializable {
    val k = first.compareTo(second)
    return if (k <= 0) first else second
}

class SerializableYear(val value: Int): Comparable<SerializableYear>, Serializable {
    override fun compareTo(other: SerializableYear): Int =
    this.value.compareTo(other.value)
}

val b = minSerializable(SerializableYear(1969), SerializableYear(1802))


// Classes with Multiple upper bounds
class MultipleBoundedClass<T> where T : Comparable<T>, T : Serializable
```

#### Star Projections

Whenever the Type T is unknown and needs to be safely accessed then star projections \(\*\) are used.

> Note: star-projections are very much like Java's raw types, but safe.

```kotlin
// Use of the raw type for unknown element type - Can't do this in Kotlin!(Throws compile error)
  fun numElementsInCommon(s1: Set, s2: Set): Int {
    var result = 0
    for (o1 in s1)
      if (s2.contains(o1))
        result++
    return result
  }

  // Star Projections - typesafe and flexible
  fun numElementsInCommon(s1: Set<*>, s2: Set<*>): Int {
    var result = 0
    for (o1 in s1)
      if (s2.contains(o1))
        result++
    return result
  }
```

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Box.kt)

---

## Item 24: Eliminate unchecked warnings

Unchecked checked warning always occur when working with Generics

* Cast warnings
* Method Invocation warnings
* Generic array creation warnings
* Conversion warnings

> Always eliminate every unchecked warning that you can.

If you cannot eliminate a warning but you can prove that your code is typesafe, then and only then suppress the warning with a`@SuppressWarnings("unchecked")`annotati

> Always use`@SuppressWarnings`annotation on the smallest scope possible. Try moving it into a local variable instead of a method if possible.

You cannot use the`@SuppressWarnings`annotation on the return of a function and so you should declare a local variable to handle that.

> Every time you add the`@SuppressWarnings`annotatin, don't forget to add a comment to mention why it's safe to do so.

Also leaving out unchecked warnings creates a sense of complacency which might result in an important warning being left out. So, it is wise to make a decision on suppressing annotations safely and correcting errors that could be corrected.

**Kotlin has removed checked exceptions completely citing the reasons of producing verbose, meaningless cod**

---

## Item 25: Prefer lists to arrays

Arrays are covariant in the sense that they can have subtypes and supertypes with respect to their extends relationship. A generic type is invariants which do share the same relationship. But they try to simulate the same with type variance and covariance/contravariance.

#### Type variance

> #### Invariant

When type parameters are invariant, there is no subtype relationship between the types. That is to say, a type M&lt;T&gt; is neither a subtype nor a supertype of M&lt;U&gt;, regardless of the relationship between T and U. So to the compiler a Crate and a Crate&lt;Fruit&gt; are as related as a Crate&lt;Apple&gt; and a Crate&lt;BigDecimal&gt;.

```kotlin
class Fruit
class Apple: Fruit()
class Orange: Fruit()
class Crate<T>(val elements: MutableList<T>) { // Crate is just a wrapper around fruits
    fun add(t: T) = elements.add(t)
    fun last(): T = elements.last()
}

fun foo(crate: Crate<Fruit>): Unit {
    crate.add(Apple()) // does not compile
}

val oranges = Crate(mutableListOf(Orange(), Orange())) // Since crate can have any fruit, it could also have apples but that would result in an illegal ClassCastException when retrieving the elements
foo(oranges)
val orange: Orange = oranges.last()

```

> #### Covariance

Covariance is used to safely create the subtype-supertype relationship when the logic is sound. This can be done by prefixing the`out`keyword before the Type parameter. Covariance is incredibly powerful and used by many immutable collection types: Sets, lists, maps, iterators, and collections all define type parameters as covariant, in addition to Pair, Triple, Lazy, and much more.

```kotlin
class Crate<out T>(val elements: List<T>) {
fun last(): T = elements.last()
}

// Happy compiler
val oranges = Crate(listOf(Orange(), Orange()))
isSafe(oranges)
```

> #### Covariant return

The return type of a function could also be of a Covariant type.

```kotlin
open class Animal
class Sheep: Animal()
class Frog: Animal()

abstract class Farm {
    abstract fun get(): Animal
}

abstract class SheepFarm() : Farm() {
    abstract override fun get(): Sheep
}

val farm: Farm = SheepFarm()
val animal1 = farm.get()
val sheepFarm = SheepFarm()
val animal2 = sheepFarm.get()

```



