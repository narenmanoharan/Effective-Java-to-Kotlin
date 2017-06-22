# Effective Kotlin

[![codebeat badge](https://codebeat.co/badges/55c838ce-608d-4eeb-a706-36117513f1a7)](https://codebeat.co/projects/github-com-narenkmanoharan-effective-kotlin-master) [![Build Status](https://travis-ci.org/narenkmanoharan/Effective-Kotlin.svg?branch=master)](https://travis-ci.org/narenkmanoharan/Effective-Kotlin) [![codecov](https://codecov.io/gh/narenkmanoharan/Effective-Kotlin/branch/master/graph/badge.svg)](https://codecov.io/gh/narenkmanoharan/Effective-Kotlin) [![CircleCI](https://circleci.com/gh/narenkmanoharan/Effective-Kotlin.svg?style=svg)](https://circleci.com/gh/narenkmanoharan/Effective-Kotlin) 


Kotlin implementation of the effective java items from [Effective Java](https://www.amazon.com/Effective-Java-2nd-Joshua-Bloch/dp/0321356683) book by Joshua Block.

## Table of Contents

#### 1. Creating and Destroying objects

Item 1: [Static Factory Methods](#static-factory-methods)

Item 2: [Builder Pattern](#builder-pattern)

Item 3: [Singleton Pattern](#singleton-pattern)

Item 4: [Private Constructors](#private-constructors)

Item 5: [Avoid creating unnecessary objects](#avoid-creating-unnecessary-objects)

Item 6: [Eliminate Obsolete Object References](#eliminate-obsolete-object-references)

Item 7: [Avoid finalizers](#avoid-finalizers)

#### 2. Methods common to all objects

Item 8: [Overriding Equals](#overriding-equals)

Item 9: [Overriding Hashcode](#overriding-hashcode)

Item 10: [Overriding toString](#overriding-tostring)

Item 11: [Cloning Objects](#cloning-objects)

Item 12: [Implementing Comparable and Using Comparators](#implementing-comparable-and-using-comparators)

#### 3. Classes and Interfaces

Item 13: [Class and Member accessibility minimization](#class-and-member-accessibility-minimization)

Item 14: [Accessor Methods or Properties](#accessor-methods-or-properties)g

Item 15: [Minimize Mutability](#minimize-mutability)

Item 16: [Favor Composition over Inheritance](#favor-composition-over-inheritance)

Item 17: [Design and Document for inheritance or else prohibit it](#design-and-document-for-inheritance-or-else-prohibit-it)

Item 18: [Prefer interfaces to abstract classes](#prefer-interfaces-to-abstract-classes)

Item 19: [Use interface only to define types](#use-interface-only-to-define-types)

## Static Factory Methods

A simple static method that returns an instance of the class. Implemented in Kotlin using [Object declarations.](https://kotlinlang.org/docs/reference/object-declarations.html)

#### Pros

- Named "constructors".
- Do not have to create new instances every time - Can return null, if appropriate.
- Return an object of any subtype of their return type - Can return an instance of a derived class, if appropriate.
- Reduces the verbosity of creating parameterized type instances.

#### Cons

- Classes without public or protected constructors cannot be subclassed.

#### Common names

- valueOf
- of
- getInstance
- newInstance
- getType
- newType

**[Code available here](https:/github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Car.kt)**

--

## Builder Pattern

This pattern is used when designing classes whose constructors may have more than a handful of parameters. They also simulate the behavior of named optional parameters which are available in Kotlin. 

In most cases you don't need to use builders in Kotlin because we have default and named arguments. But, it is nice to have.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Vacation.kt)**

--

## Singleton Pattern

Used in order to ensure a class only has one instance, and provide a global point of access to it. But this is mostly considered an Anti-pattern in the OOD community because of it's behavior in relation to the design principles.

- Private constructor is used to ensure this class can’t be initialized anywhere except inside of this class.

#### Pros

- Lazy initialization
- Thread safe (Use of static block to instantiate object)
- Static Initialization

#### Cons

- Hides dependencies in the code rather than exposing it through interfaces. 
- Has its own lifetime and so making it [difficult to test](http://misko.hevery.com/2008/08/17/singletons-are-pathological-liars/). 
- They violate the single responsibility principle: by virtue of the fact that they control their own creation and lifecycle.
- Produces tightly coupled code.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Database.kt)**

--

## Non-instantiability using Private Constructors

In order to ensure non-instantiability of a class, a private constructor might come in handy. Using this we can make sure that we only instantiate the class when absolutely required using a factory or builder pattern.

#### Cases

- To prevent instantiation outside of the object in
    - Singleton
    - Factory Method
    - Static-methods-only (utility) class
    - Constants-only class

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Burger.kt)**

--

## Avoid creating unnecessary objects

Be careful when creating objects to make sure to reuse objects when possible. This can be done by the use of the init method available in Kotlin to initialize an object whenever the class is initialized, rather than having it be created every time a method is called on an instance. This helps with better performance and memory consumption.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Pizza.kt)**

--

## Eliminate Obsolete Object References

Memory leakage is a serious issue that we need take care of in both Java and Kotlin which can easily lead to an OutOfMemoryError if not carefully dealt with. Also it might adversely affect the performance of the program by increased garbage collector activity or increased memory footprint. 

This can be nulling out references that you don't need anymore. But this should be an exception rather than a norm.

#### Sources of Memory leaks

- Whenever a class manages its own memory, the programmer should be alert for memory leaks
- Memory leaks in Cache
- Another source is listeners and other callbacks (Specifically callbacks in Android whether be it Asynctasks or OnClickListeners)

--

## Avoid finalizers

Finalize() in Kotlin which is usually called with Java is not guaranteed to be called when declared and so anything time sensitive should never be done in them. They are unpredictable and exhibit erratic behavior. Finalize is not synonymous to destructors in C++. Also System.gc and System.runFinalization.

Also there is severe performance penalty for using finalizers.  

--

## Overriding Equals

Don't override the equals method if 

- Each instance of the class is inherently unique
- Superclass has overridden equals method
- When the package is private 

```
  override fun equals(other: Any?): Boolean {
        throw AssertionError() // Method is never called}
```

Override the equals method if

- Logical equality is important

Equals method implements an equivalence relation:

1. **Reflexive**: For any non-null reference value x,

    ` x.equals(x)` must return `true`
    
2. **Symmetric**: For any non-null reference values x and y,

    `x.equals(y)` must return `true` if and only if `y.equals(x)` returns `true`.
    
3. **Transitive**: For any non-null reference values x, y, z, 

    `if x.equals(y)` returns `true` and `y.equals(z)` returns `true`,               then `x.equals(z)` must return `true`.
    
4. **Consistent**: For any non-null reference values x and y, 

    multiple invocations of `x.equals(y)` consistently return `true` or consistently return `false`, provided no information used in equals comparisons on the objects is modified.

5. For any non-null reference value x, 

    `x.equals(null)` must return `false`.
    

Do not write equals method on unreliable resources.


#### Steps to write a high quality `equals` method

- Use the `===` operator to check if the argument is a reference to the object
- Check if the `javaclass` of both the objects are the same
- Cast the argument to the correct type
- Every significant field in the class needs to be checked for logical equality to the corresponding field of the object
- Check if the method obeys symmetry, transitivity and if it is consistent.
- Also make sure to override the `hashCode` method.

> **In Kotlin, we get all this for free using the `data class` provided by default**
    
**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Person.kt)**

--

## Overriding Hashcode

There is a rule to always override `hashCode` whenever `equals` is overridden. If this is not obeyed, then this would result in a violation of the contract of the Object.hashCode method and will prevent the class from functioning properly in conjunction with all the has-based collections.

The vital part of writing the `hashCode` method relies on the fact that **equal objects must have equal hash codes**. A good hashCode should always produce different hashcodes for unequal objects.

> **In Kotlin, we get all this for free using the `data class` provided by default**

#### Steps to write a high quality `hashCode` method

- Store a constant non zero value calculated from any attribute of the class using it's superclass method

```
var result = fName.hashCode()
```

- For each significant field f (All field defined in the `equals` method), do the following

    - Compute an `Int hashCode c` for the field
        
        - Boolean: `f ?: 0`
        - Byte, Char, Short, Float, Double, Int: `f.toInt()`
        - Long: `(f ^ (f >>> 32)).toInt()`
        - The class's `equals` method compares the field by recursively invoking equals and invoke the `hashCode` on the field.
        - Array: Each element is treated as a separate field by applying the rules recursively.

> **In Kotlin, we get all this for free using the `data class` provided by default**

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Person.kt)**

--

## Overriding toString

A good `toString` implementation makes the class much more pleasant to use. It clearly displays the most significant information required in a class object. If the `toString` method is not overridden, then printing the object would returns the class name followed by the unsigned hexadecimal representation of the hashcode.

If there is a specific format of the `toString` then mention them in the documentation. If not then make a specific comment about the `toString` method. 

Also provide programmatic access to all the information contained in the value returned by `toString`.

> **In Kotlin, we get all this for free using the `data class` provided by default**

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Person.kt)**

--

## Cloning Objects

Cloning in kotlin is as easy as calling the copy method from the data class. The method provided by the data class offers the following:

```
- x.copy() !== x
- x.javaClass == x.copy().javaClass
- x.copy().equals(x)
```

This method provided by Kotlin itself, satisfies all the requirements that are requested by the contract of implementing the Cloneable interface in Java to expose the protected clone() method in the object class.

And in this method we could also provide named arguments as to what should be different from the data class it is cloned from. The data class in kotlin uses the copy constructor approach from java to implement it's cloning facility.

It uses a copy constructor and a static factory which provides a lot more robustness over implementing the cloneable interface. Such as

- Doesn't rely on a risk-prone extralinguistic object creation mechanism
- Doesn't demand unenforceable adherence to not-so documented conventions
- Doesn't conflict with vals
- Doesn't throw checked exceptions
- Doesn't require casts
- Add interface like functionality since Cloneable doesn't have a public `clone` method


**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Sheep.kt)**

-- 

## Implementing Comparable and Using Comparators

Implementing the comparable interface in the class provides a "natural" way of ordering the objects created by the class. The `compareTo` method provided by the comparable interface is used to sort the collection in the way specified. The general contract of the `compareTo` method is similar to that of the `equals` method. 

- Compare `this` object with the other object provided
- Returns a negative integer if the object is less than the object it is compared to.
- Returns zero if they are equal
- Returns a positive integer if the object is greater than the object it is compared to.
- Throws `ClassCastException` if the specified object's type prevents it from being compared to this object.

The contract specification goes as follows

```
- x.compareTo(y) == -y.compareTo(x) for all x and y
- Transitivity: (x.compareTo(y) > 0 && y.compareTo(z) > 0)
- if x.compareTo(y) == 0, then x.compareTo(z) == y.compareTo(z) 
- Recommendation: (x.compareTo(y) == 0) == (x.equals(y))

```

#### `compareBy` using Comparator

The `compareBy` function available in Kotlin is used to sort an object with multiple fields with the use of comparators and method references. This creates a comparator using the sequence of functions to calculate a result of comparison. This is called in the sequence that we need the list to be ordered.

```
// Using the it operator
val sortedListOfMovies: List<Movies> = list.sortedWith(compareBy({ it.rating }, { it.year }))

// Using method references 
val sortedListOfMovies: List<Movie> = moviesList.sortedWith(compareBy(Movie::rating, Movie::year))
```

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Movie.kt)**

-- 

## Class and Member accessibility minimization

#### Rule of thumb: Make each class or member as inaccessible as possible.

Kotlin helps in this regard by making every class uninheritable by default. So, in order to make a class support inheritance, we need to mention `open class` to enable it.

Also instance fields should always be private and preferred to be immutable to make sure that it is thread-safe.

And there are four specific access specifiers

1. private
2. package-private
3. protected
4. public

#### Dealing with arrays and Static Fields

When dealing with arrays in accessor fields make sure that  you either return a copy of the array or an immutableList that cannot be changed.
It is important that the user does not tamper with the references.

Ensure that the Public API that you build has only constant static fields as the only available public fields. 

The data class in kotlin provides us with all the necessary tools under the hood to achieve all this with just the keyword.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Bear.kt)**

-- 


## Accessor Methods or Properties

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

var setterVisibility: String = "abc"
    private set // the setter is private and has the default implementation

var setterWithAnnotation: Any? = null
    @Inject set // annotate the setter with Inject

```

Also public classes should never expose mutable fields. If a class is package-private or is a private nested class, then exposing the properties is not a problem.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/HeightConverter.kt)**

-- 

## Minimize Mutability

Immutability is an important concept in programming especially concurrent programming where multiple threads might try and access a specific resource. Making the resource immutable helps us make sure that the state isn't altered by any one thread and read incorrectly by other threads leading to a race condition.

By making a class immutable we can control the number of state it could be in by creating objects corresponding each state either using constructors or static factories. Kotlin heavily places emphasis on making objects and classes immutable with the introduction of `val`.

> **The general rule of thumb in Kotlin is to make every reference a val is possible.**

Immutable classes in general are easier to design, implement and use than its mutable variants. They are also less error prone and more secure.

Here are the rules to make a class immutable,

- Do not provide method to mutate the objects state (Mutators)
- Leave the class closed by default - To stop subclassing
- All the properties should be `private vals`
- Exclusive access to any mutable components - If the class has property that refers to mutable objects then make sure that it does not contain any reference to these objects. Always return a defensive copy in constructors, accessors and readObject methods.

#### Advantages of Immutable Objects

- Simple
- Thread Safe (Require no synchronization)
- Can be shared freely
- No defensive copies needed in case of immutable objects (ImmutableList)
- No copies of the same object needed (Do not provide clone method)
- Share their internals as well (Just a property)
- Great building blocks for other objects


#### Disadvantages 

- Require separate objects for each distinct value
- Serialization might be a problem

#### Remember

Before creating an instance make sure that the object is of the class type that we require and not a subclass of the same. If so, then make a defensive copy of the object to make sure it cannot be modified.

Also implicitly making the object lazy also helps when trying to retrieve the property of the object multiple times.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Complex.kt)**

-- 

## Favor Composition over Inheritance

In this module, we will discuss the effects of *implementation inheritance* which occurs when one class inherits another. The other case where *interface inheritance* takes place does not have any glaring holes that needs to be addressed.


> **Composition models the "has-a" relationship**

> **Inheritance extends the "is-a" relationship**


Only use inheritance when the class that you are extending has been documented for inheritance and does not have any self-use calls that haven't been documented. For all other cases, use composition instead.

#### Problems with Implementation Inheritance

Inheritance in general violates encapsulation. In order to create a subclass from a class, we need open up the class for extension which breaks encapsulation and many other SOLID principles that we talked about. Also inheritance creates dependence upon the superclass so as to make sure we propagate the change that takes place in the superclass. If a specific change is made to the superclass and it is not addressed in the subclasses then most of the time, the code breaks.

This is why it is always important to **inherit only from classes which are documented for inheritance.** In these classes, we have all the information we know and a contract such that if a code breaking change is made, then we have the proper documentation to fix it as soon as possible.

Also if we try and overcome these issues by just adding methods to the subclass without overriding them. Then we might run into an unfortunate error where there might be a new method added with the same name and different return type. This will result in a compilation error since JLS 8.4.8.3

> **Composition:** The technique where we provide the new class with a reference to an instance of the superclass without extending it. Hence, the existing class becomes the component of the new one. 

> **Forwarding:** Each instance method in the new class invokes the corresponding method *(Forwarding method)* on the contained instance of the existing class *(Forwarding Class)*.

This is similar to the **decorator pattern** seen in the SOLID principles and Kotlin has inbuilt support for it.

```kotlin

class Rectangle(val width:Int, val height:Int) {
    fun area() = width * height
}

class Window(val bounds:Rectangle) {
    // Delegation
    fun area() = bounds.area()
}

```

> This type of forwarding is loosely known as Delegation

Also these type of compositions are not suitable for Callback frameworks where objects references get passed around. In this case, the SELF reference of the class gets muddled and so it is better to avoid the wrapper class in such cases.

> **Rule of thumb: Check if the following can be implemented using Composition before using Inheritance.**

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/CEO.kt)**

-- 

## Design and Document for inheritance or else prohibit it

Inheriting a class that is not documented for inheritance will always result in broken and unmanageable code. As we saw in the previous module, documenting an `open class` with all the necessary information known to inherit the methods is vital to inheritance.

In order to achieve proper documentation of a class for inheritance, the class should have the following

- The class should document its self-use of overridable methods
- Provide details into the internal workings of the protected methods which might be inherited
- Test the classes by creating various subclasses
- Constructors must not invoke overridable methods
- Neither the clone nor readObject methods should be able to invoke the overridable methods directly or indirectly
- Designing a class for inheritance, substantially limit what a class can do.

Kotlin provides the `open class` operator to explicitly open a class for inheritance only when needed. And to add to that, in kotlin we need to `open fun` to open up the methods we need to override and `open val/var` to open up properties.

```
open class Animal {
    ...
}

class Dog : Animal {
    ...
}

```


**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Animal.kt)**

-- 

## Prefer interfaces to abstract classes

Two ways that permits multiple implementations:

1. Interfaces
2. Abstract Classes

#### Advantages of using Interfaces

> Existing classes can easily implement a new interface

All a class has to do when it comes to implementing a new interface is to implement all the required methods (Non default methods). This cannot be said about abstract class high up in the type hierarchy where it subclasses an ancestor of both classes. This might end up forcing all its descendants to extend the new abstract class whether or not is appropriate for them.

> Interfaces are ideal for defining mixins

A mixin is a type that a class can implement in addition to its "primary type" to declare that it provides some optional behavior. *Eg: Comparable*. Abstract classes cannot be used for this purpose.

> Non-hierarchical type frameworks

Type hierarchy is difficult to build since real world instances do not exactly fit into a rigid hierarchy. This can only be modeled by interfaces in the way with the flexibility that we need.

> Enable safe, powerful functionality enhancements

If abstract classes are used to implement inheritance in the first go, then we leave the programmer no option to use composition/wrapper classes to extend functionality. In Kotlin, interfaces could have implementations by default which can be overridden by the inheriting class if needed.

> Skeletal implementations (AbstractImplementations) are a combination of interfaces and abstract classes which combine together to allows ***Simulated Multiple Inheritance***. 

Documenting such skeletal implementations are vital since they are designed for inheritance. Unlike in Java 7, Kotlin interfaces can have also have default implementations in them which take away the evolution advantage of the abstract class.

> Both Java 8 and Kotlin add flexibility to interfaces with default method implementations which greatly add flexibility to the interfaces and help improve the functionality.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Skeleton.kt)**

-- 

## Use interface only to define types

Interface should only be used to define *types* for the class which implements it. The interface should say something about the client instances which implement them.

> An important anti-pattern which should be avoided is the **Constant Interface anti-pattern** (Poor use of interface)

This might cause implementation detail to leak into the class's exported API. If a superclass implements the constants interface then all its subclasses are polluted by the constants in the interface.

#### Best ways to implement constants

- In an existing class or interface, just add them in the class or interface. *Eg. Integer (MAX_VALUE, MIN_VALUE)*

- If the constants are best viewed as the members of an enum type them implement them as an enum class

- Export them in a non-instantiable Utility class.

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

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/TheNYTimes.kt)**

-- 


