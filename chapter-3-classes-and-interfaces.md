## Item 13: Class and Member accessibility minimization

#### Rule of thumb: Make each class or member as inaccessible as possible.

Kotlin helps in this regard by making every class uninheritable by default. So, in order to make a class support inheritance, we need to mention`open class`to enable it.

Also, instance fields should always be private and preferred to be immutable to make sure that it is thread-safe.

And there are four specific access specifiers

1. private
2. package-private
3. protected
4. public

#### Dealing with arrays and Static Fields

When dealing with arrays in accessor fields make sure that you either return a copy of the array or an immutableList that cannot be changed. It is important that the user does not tamper with the references.

Ensure that the Public API that you build has only constant static fields as the only available public fields.

The data class in kotlin provides us with all the necessary tools under the hood to achieve all this with just the keyword.

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Bear.kt)

---

## Item 14: Accessor Methods or Properties

Do not use public properties which are mutable. This could adversely encapsulation. In Kotlin, properties function as default getters and setters meaning that we don't explicit have to method getters and setters for every field that we have in a class. But it helps to set custom getters and setters as follows.

```kotlin
var integerRepresentation: String
    get() = this.toInt()
    set(value) {
        setDataFromInt(value) // parses the string and assigns values to other properties
}
```

We can also make sure that the properties remain private using the following:

```kotlin
var setterVisibility: String = "ABC"
    private set // the setter is private and has the default implementation

var setterWithAnnotation: Any? = null
    @Inject set // annotate the setter with Inject
```

Also, public classes should never expose mutable fields. If a class is package-private or is a private nested class, then exposing the properties is not a problem.

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/HeightConverter.kt)

---

## Item 15: Minimize Mutability

Immutability is an important concept in programming especially concurrent programming where multiple threads might try and access a specific resource. Making the resource immutable helps us make sure that the state isn't altered by any one thread and read incorrectly by other threads leading to a race condition.

By making a class immutable we can control the number of states it could be in by creating objects corresponding each state either using constructors or static factories. Kotlin heavily places emphasis on making objects and classes immutable with the introduction of`val`.

> **The general rule of thumb in Kotlin is to make every reference a val is possible.**

Immutable classes, in general, are easier to design, implement and use than its mutable variants. They are also less error prone and more secure.

Here are the rules to make a class immutable,

* Do not provide method to mutate the objects state \(Mutators\)
* Leave the class closed by default - To stop subclassing
* All the properties should be
  `private vals`
* Exclusive access to any mutable components - If the class has a property that refers to mutable objects then make sure that it does not contain any reference to these objects. Always return a defensive copy in constructors, accessors and readObject methods.

#### Advantages of Immutable Objects

* Simple
* Thread Safe \(Require no synchronization\)
* Can be shared freely
* No defensive copies needed in case of immutable objects \(ImmutableList\)
* No copies of the same object needed \(Do not provide clone method\)
* Share their internals as well \(Just a property\)
* Great building blocks for other objects

#### Disadvantages

* Require separate objects for each distinct value
* Serialization might be a problem

#### Remember

Before creating an instance make sure that the object is of the class type that we require and not a subclass of the same. If so, then make a defensive copy of the object to make sure it cannot be modified.

Also implicitly making the object lazy also helps when trying to retrieve the property of the object multiple times.

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Complex.kt)

---

## Item 16: Favor Composition over Inheritance

In this module, we will discuss the effects of\_implementation inheritance\_which occurs when one class inherits another. The other case where\_interface inheritance\_takes place does not have any glaring holes that need to be addressed.

> **Composition models the "has-a" relationship**
>
> **Inheritance extends the "is-a" relationship**

Only use inheritance when the class that you are extending has been documented for inheritance and does not have any self-use calls that haven't been documented. For all other cases, use composition instead.

#### Problems with Implementation Inheritance

Inheritance, in general, violates encapsulation. In order to create a subclass from a class, we need open up the class for an extension which breaks encapsulation and many other SOLID principles that we talked about. Also, inheritance creates dependence upon the superclass so as to make sure we propagate the change that takes place in the superclass. If a specific change is made to the superclass and it is not addressed in the subclasses then most of the time, the code breaks.

This is why it is always important to**inherit only from classes which are documented for inheritance.**In these classes, we have all the information we know and a contract such that if a code breaking change is made, then we have the proper documentation to fix it as soon as possible.

Also if we try and overcome these issues by just adding methods to the subclass without overriding them. Then we might run into an unfortunate error where there might be a new method added with the same name and different return type. This will result in a compilation error since JLS 8.4.8.3

> **Composition:**The technique where we provide the new class with a reference to an instance of the superclass without extending it. Hence, the existing class becomes the component of the new one.
>
> **Forwarding:**Each instance method in the new class invokes the corresponding method_\(Forwarding method\)\_on the contained instance of the existing class_\(Forwarding Class\)\_.

This is similar to the **decorator pattern **seen in the SOLID principles and Kotlin has inbuilt support for it.

```kotlin
class Rectangle(val width:Int, val height:Int) {
    fun area() = width * height
}

class Window(val bounds:Rectangle) {
    // Delegation
    fun area() = bounds.area()
}
```

This type of forwarding is loosely known as Delegation

Also, these type of compositions is not suitable for Callback frameworks where objects references get passed around. In this case, the SELF-reference of the class gets muddled and so it is better to avoid the wrapper class in such cases.

> **Rule of thumb: Check if the following can be implemented using Composition before using Inheritance.**

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/CEO.kt)

---

## Item 17: Design and Document for inheritance or else prohibit it

Inheriting a class that is not documented for inheritance will always result in broken and unmanageable code. As we saw in the previous module, documenting an`open class`with all the necessary information known to inherit the methods is vital to inheritance.

In order to achieve proper documentation of a class for inheritance, the class should have the following

* The class should document its self-use of overridable methods
* Provide details into the internal workings of the protected methods which might be inherited
* Test the classes by creating various subclasses
* Constructors must not invoke overridable methods
* Neither the clone nor readObject methods should be able to invoke the overridable methods directly or indirectly
* Designing a class for inheritance, substantially limit what a class can do.

Kotlin provides the`open class`operator to explicitly open a class for inheritance only when needed. And to add to that, in kotlin we need to`open fun`to open up the methods we need to override and`open val/var`to open up properties.

```kotlin
open class Animal {
    ...
}

class Dog: Animal {
    ...
}
```

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Animal.kt)

---

## Item 18: Prefer interfaces to abstract classes

Two ways that permit multiple implementations:

1. Interfaces
2. Abstract Classes

#### Advantages of using Interfaces

> Existing classes can easily implement a new interface

All a class has to do when it comes to implementing a new interface is to implement all the required methods \(Nondefault methods\). This cannot be said about abstract class high up in the type hierarchy where it subclasses an ancestor of both classes. This might end up forcing all its descendants to extend the new abstract class whether or not is appropriate for them.

> Interfaces are ideal for defining mixins

A mixin is a type that a class can implement in addition to its "primary type" to declare that it provides some optional behavior._Eg: Comparable_. Abstract classes cannot be used for this purpose.

> Non-hierarchical type frameworks

The type hierarchy is difficult to build since real world instances do not exactly fit into a rigid hierarchy. This can only be modeled by interfaces in the way with the flexibility that we need.

> Enable safe, powerful functionality enhancements

If abstract classes are used to implement inheritance in the first go, then we leave the programmer no option to use composition/wrapper classes to extend functionality. In Kotlin, interfaces could have implementations by default which can be overridden by the inheriting class if needed.

> Skeletal implementations \(AbstractImplementations\) are a combination of interfaces and abstract classes which combine together to allows_**Simulated Multiple Inheritance**_.

Documenting such skeletal implementations are vital since they are designed for inheritance. Unlike in Java 7, Kotlin interfaces can have also had default implementations in them which take away the evolutionary advantage of the abstract class.

> Both Java 8 and Kotlin add flexibility to interfaces with default method implementations which greatly add flexibility to the interfaces and help improve the functionality.

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Skeleton.kt)

---

## Item 19: Use interface only to define types

The interface should only be used to define\_types\_for the class which implements it. The interface should say something about the client instances which implement them.

> An important anti-pattern which should be avoided is the**Constant Interface anti-pattern**\(Poor use of interface\)

This might cause implementation detail to leak into the class's exported API. If a superclass implements the constants interface then all its subclasses are polluted by the constants in the interface.

#### Best ways to implement constants

* In an existing class or interface, just add them in the class or interface._Eg. Integer \(MAX\_VALUE, MIN\_VALUE\)_

* If the constants are best viewed as the members of an enum type them to implement them as an enum class

* Export them in a non-instantiable Utility class.

```kotlin
class TheNYTimesAPI {
  companion object {
    const val API_KEY = "bfa504d8afec47basdfsda7b3dab9201ddd"
    const val BASE_URL = "https://api.nytimes.com/"
    const val API_ENDPOINT = "/svc/search/v2/articlesearch.json"
  }
}
```

**Rule of thumb: Do not use interfaces to export constants**

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/TheNYTimesAPI.kt)

---

## Item 20: Prefer class hierarchies to tagged classes

> Tagged class is a class defined using enums and tag fields through which the instances are flavored.

They are cluttered with boilerplate, including enum declarations, tag fields, and switch statements. Memory usage of these instances is burdened with irrelevant fields belonging to other flavors.**Tagged classes are verbose, error-prone and inefficient**

**A tagged class is a pallid imitation of a class hierarchy.**Abstract classes and interfaces are used to model this class hierarchy the way we want to. This can add much more flexibility to the class that we build. This class can be further extending to house even more features and flavors.

**Rule of thumb: Do not use tagged classes but use class hierarchy instead**

```kotlin
abstract class Figure {
  abstract fun area(): Double
}

class Circle(val radius: Int) : Figure() {

  override fun area(): Double {
    return Math.PI * (radius * radius)
  }

}

open class Rectangle(val length: Int, val width: Int) : Figure() {

  override fun area(): Double {
    return (length * width).toDouble()
  }
}
```

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Figure.kt)

---



