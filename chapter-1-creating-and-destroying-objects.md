## Item 1: Static Factory Methods

A simple static method that returns an instance of the class. Implemented in Kotlin using [Object declarations.](https://kotlinlang.org/docs/reference/object-declarations.html)

> The key idea of the static factory method is to gain control over object creation and delegate it from constructor to static method. The decision of object to be created is like in Abstract Factory made outside the method \(in the common case, but not always\). While the key \(!\) idea of Factory Method is to delegate the decision of what instance of the class to create inside Factory Method.

#### Pros

* Named "constructors".
* Do not have to create new instances every time - Can return null, if appropriate.
* Return an object of any subtype of their return type - Can return an instance of a derived class, if appropriate.
* Reduces the verbosity of creating parameterized type instances.

#### Cons

* Classes without public or protected constructors cannot be subclassed.

```kotlin
private constructor(private val model: String,
    private val brand: Brand,
    private val maxSpeed: Int? ,
    private val hp: Int?,
    private val torque: Int?,
    private val seating: Int?,
    private val mileage: Int?) {

  companion object {

    fun valueOf(model: String,
                brand: Brand,
                maxSpeed: Int?,
                hp: Int?,
                torque: Int?,
                seating: Int?,
                mileage: Int?): Car {
      return Car(model, brand, maxSpeed, hp, torque, seating, mileage)
    }
  }
```

#### Common names

* valueOf
* of
* getInstance
* newInstance
* getType
* newType

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Car.kt)

---

## Item 2: Builder Pattern

This pattern is used when designing classes whose constructors may have more than a handful of parameters. They also simulate the behavior of named optional parameters which are available in Kotlin.

> In most cases, you don't need to use builders in Kotlin since we have default and named arguments. But it is nice to have.

#### Rules of Thumb

* Sometimes creational patterns are complementary: Builder can use one of the other patterns to implement which components get built. Abstract Factory, Builder, and Prototype can use Singleton in their implementations.

* Builder focuses on constructing a complex object step by step. Abstract Factory emphasizes a family of product objects \(either simple or complex\). Builder returns the product as a final step, but as far as the Abstract Factory is concerned, the product gets returned immediately.

* Builder often builds a Composite.

* Often, designs start out using Factory Method \(less complicated, more customizable, subclasses proliferate\) and evolve toward Abstract Factory, Prototype, or Builder \(more flexible, more complex\) as the designer discovers where more flexibility is needed.

```kotlin
class Vacation (val destination: String?, val duration: Int, val mode: Mode, val cost: Int) {

  private constructor(builder: Vacation.Builder) : this(builder.destination, builder.duration, builder.mode, builder.cost)

  companion object {
    inline fun build(mode: Mode, cost: Int, block: Vacation.Builder.() -> Unit) = Vacation.Builder(mode, cost).apply(block).build()
  }

  class Builder(val mode: Mode,val cost: Int) {
    var destination: String? = null
    var duration: Int = 0

    fun build() = Vacation(this)
  }
}
```

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Vacation.kt)

---

## Item 3: Singleton Pattern

Used in order to ensure a class only has one instance, and provide a global point of access to it. But this is mostly considered an Anti-pattern in the OOD community because of its behavior in relation to the design principles.

> The private constructor is used to ensuring this class can’t be initialized anywhere except inside of this class.

#### Pros

* Lazy initialization
* Thread safe \(Use of static block to instantiate object\)
* Static Initialization

#### Cons

* Hides dependencies in the code rather than exposing it through interfaces.
* Has its own lifetime and so making it [difficult to test](http://misko.hevery.com/2008/08/17/singletons-are-pathological-liars/)
* They violate the single responsibility principle: by virtue of the fact that they control their own creation and lifecycle.
* Produces tightly coupled code.

#### Rules of Thumb

* Abstract Factory, Builder, and Prototype can use Singleton in their implementation.

* Facade objects are often Singletons because only one Facade object is required.

* State objects are often Singletons.

* The advantage of Singleton over global variables is that you are absolutely sure of the number of instances when you use Singleton, and, you can change your mind and manage any number of instances.

* The Singleton design pattern is one of the most inappropriately used patterns. Singletons are intended to be used when a class must have exactly one instance, no more, no less. Designers frequently use Singletons in a misguided attempt to replace global variables. A Singleton is, for intents and purposes, a global variable. The Singleton does not do away with the global; it merely renames it.

* When is Singleton unnecessary? Short answer: most of the time. Long answer: when it's simpler to pass an object resource as a reference to the objects that need it, rather than letting objects access the resource globally. The real problem with Singletons is that they give you such a good excuse not to think carefully about the appropriate visibility of an object. Finding the right balance of exposure and protection for an object is critical for maintaining flexibility.

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Database.kt)

---

## Item 4: Non-instantiability using Private Constructors

In order to ensure non-instantiability of a class, a private constructor might come in handy. Using this we can make sure that we only instantiate the class when absolutely required using a factory or builder pattern.

Utility classes are not designed to be instantiated: an instance would be nonsensical. In the absence of explicit constructors, however, the compiler provides a public, parameterless default constructor. To a user, this constructor is indistinguishable from any other. It is not uncommon to see unintentionally instantiable classes in published APIs.

> There is, however, a simple idiom to ensure noninstantiability. A default constructor is generated only if a class contains no explicit constructors, so a class can be made noninstantiable by including a private constructor.

#### Cases

* To prevent instantiation outside of the object in
  * Singleton
  * Factory Method
  * Static-methods-only \(utility\) class
  * Constants-only class

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Burger.kt)

---

## Item 5: Avoid creating unnecessary objects

Be careful when creating objects to make sure to reuse objects when possible. This can be done by the use of the init method available in Kotlin to initialize an object whenever the class is initialized, rather than having it be created every time a method is called on an instance. This helps with better performance and memory consumption.

```kotlin
object BabyBoomerDetector {

    // Don't do this - Creates a new instance every time (Depends on the API)
    fun isBabyBoomer(birthDate: Date): Boolean {
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0)
        val boomStart = calendar.time

        calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0)
        val boomEnd = calendar.time

        return birthDate >= boomStart && birthDate < boomEnd
    }
}

object BetterBabyBoomerDetector {

    private var boomStart: Date
    private var boomEnd: Date

    // Do this instead - Reuses the same instance using the constructor
    init {
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0)
        boomStart = calendar.time

        calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0)
        boomEnd = calendar.time
    }

    fun isBabyBoomer(birthDate: Date): Boolean = birthDate >= boomStart && birthDate < boomEnd
}
```

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Pizza.kt)

---

## Item 6: Eliminate Obsolete Object References

Memory leakage is a serious issue that we need take care of in both Java and Kotlin which can easily lead to an OutOfMemoryError if not carefully dealt with. Also, it might adversely affect the performance of the program by increased garbage collector activity or increased memory footprint.

#### Sources of Memory leaks

* Whenever a class manages its own memory, the programmer should be vigilant for memory leaks
* Whenever an element is freed, any object references contained in the element should also be nulled out
* Caches as a source of memory leaks:
  * see WeakHashMap class
  * the cache should occasionally be cleaned \(using background thread or as a side effect of adding new entries to the cache\)
* Listeners and other callbacks \(Specifically callbacks in Android whether be it Asynctasks or OnClickListeners\) as a source of memory leaks:
  * use weak references

```kotlin
 fun pop(): E {
    if (isEmpty())
      throw RuntimeException("Stack underflow")
    val item = array[--N]
    array[N] = null             // dereferencing the array 
    return item
  }
```

#### Rules of Thumb

Programmers should not be obsessed with nulling out object references. Nulling out object references should be the exception rather than the norm. The best way to eliminate an obsolete reference is to let the variable that contained the reference fall out of scope. This occurs naturally if you define each variable in the narrowest possible scope

#### When should we null out a reference?

In the case of a stack, it maintains it’s own memory for storing elements. When array elements fall out of scope, we just need to let the garbage collector about this by nulling out the references. Whenever a class manages its own memory, the programmer should be vigilant for memory leaks. Whenever an element is freed, any object references contained in the element should be nulled out.

---

## Item 7: Avoid finalizers

`Finalize()`in Kotlin which is usually called with Java is not guaranteed to be called when declared and so anything time sensitive should never be done in them.

> They are unpredictable and exhibit erratic behavior. Finalize is not synonymous to destructors in C++.

The Java Language Specification provides several details related to Java finalizers in Section 12.6 \("Finalization of Class Instances"\). The section begins by describing Java finalizers: "The particular definition of finalize\(\) that can be invoked for an object is called the finalizer of that object. Before the storage for an object is reclaimed by the garbage collector, the Java Virtual Machine will invoke the finalizer of that object." Some of the intentionally indeterminate characteristics of Java finalizers described in this section of the Java Language Specification are quoted here:

* The Java programming language does not specify how soon a finalizer will be invoked.
* The Java programming language does not specify which thread will invoke the finalizer for any given object.
* Finalizers may be called in any order, or even concurrently.
* If an uncaught exception is thrown during the finalization, the exception is ignored and finalization of that object terminates.

> Also, there is a severe performance penalty for using finalizers.

---



