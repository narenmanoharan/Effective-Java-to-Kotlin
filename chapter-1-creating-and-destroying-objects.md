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


