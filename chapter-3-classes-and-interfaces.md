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



