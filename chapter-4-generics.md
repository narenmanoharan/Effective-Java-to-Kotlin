## Item 23: Don't Use raw types in new code

A generic class is one which is_typesafe\_and has one or more type parameters in its declaration. Generic classes and interfaces are collectively known as\_generic types_. But in Kotlin, the compiler forces you to use parameterized type definitions or else it won't compile.

```kotlin
// Parameterized collection of Animals
val listOfAnimals: List<Animal> = listOf(Lion, Tiger, Wolf)
```



