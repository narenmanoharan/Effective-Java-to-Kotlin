# Effective Kotlin

[![codebeat badge](https://codebeat.co/badges/55c838ce-608d-4eeb-a706-36117513f1a7)](https://codebeat.co/projects/github-com-narenkmanoharan-effective-kotlin-master)

Kotlin implementation of the effective java items from [Effective Java](https://www.amazon.com/Effective-Java-2nd-Joshua-Bloch/dp/0321356683) book by Joshua Block.


### Table of Contents

1. [Static Factory Methods](#static-factory-methods)
2. [Builder Pattern](#builder-pattern)

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

--

### Builder Pattern

This pattern is used when designing classes whose constructors may have more than a handful of parameters. They also simulate the behavior of named optional parameters which are available in Kotlin. 

In most cases you don't need to use builders in Kotlin because we have default and named arguments. But, it is nice to have.

--

