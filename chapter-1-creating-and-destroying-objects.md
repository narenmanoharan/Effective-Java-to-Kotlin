
---

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

