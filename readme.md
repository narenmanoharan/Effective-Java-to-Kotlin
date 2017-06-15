# Effective Kotlin

Kotlin implementation of the effective java items from [Effective Java](https://www.amazon.com/Effective-Java-2nd-Joshua-Bloch/dp/0321356683) book by Joshua Block.


### Table of Contents

1. [Static Factory Methods](#static-factory-methods)


### Static Factory Methods

A simple static method that returns an instance of the class.

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

