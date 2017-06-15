# Effective Kotlin

[![codebeat badge](https://codebeat.co/badges/55c838ce-608d-4eeb-a706-36117513f1a7)](https://codebeat.co/projects/github-com-narenkmanoharan-effective-kotlin-master)

Kotlin implementation of the effective java items from [Effective Java](https://www.amazon.com/Effective-Java-2nd-Joshua-Bloch/dp/0321356683) book by Joshua Block.


### Table of Contents

1. [Static Factory Methods](#static-factory-methods)
2. [Builder Pattern](#builder-pattern)
3. [Singleton Pattern](#singleton-pattern)
4. [Private Constructors](#private-constructors)

--- 

### Static Factory Methods

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

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/Car.kt)**

--

### Builder Pattern

This pattern is used when designing classes whose constructors may have more than a handful of parameters. They also simulate the behavior of named optional parameters which are available in Kotlin. 

In most cases you don't need to use builders in Kotlin because we have default and named arguments. But, it is nice to have.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/Vacation.kt)**

--

### Singleton Pattern

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

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/Database.kt)**

--

### Non-instantiability using Private Constructors

In order to ensure non-instantiability of a class, a private constructor might come in handy. Using this we can make sure that we only instantiate the class when absolutely required using a factory or builder pattern.

#### Cases

- To prevent instantiation outside of the object in
    - Singleton
    - Factory Method
    - Static-methods-only (utility) class
    - Constants-only class

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/Burger.kt)**

--



