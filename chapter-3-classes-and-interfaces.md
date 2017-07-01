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



