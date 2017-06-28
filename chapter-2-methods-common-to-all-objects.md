## Item 8: Overriding Equals

Don't override the equals method if

* Each instance of the class is inherently unique
* Superclass has overridden equals method
* When the package is private

```kotlin
override fun equals(other: Any?): Boolean {
    throw AssertionError() // Method is never called
}
```

Override the equals method if

* Logical equality is important

Equals method implements an equivalence relation:

1. **Reflexive**: For any non-null reference value x,

   `x.equals(x)`must return`true`

2. **Symmetric**: For any non-null reference values x and y,

   `x.equals(y)`must return`true`if and only if`y.equals(x)`returns`true`.

3. **Transitive**: For any non-null reference values x, y, z,

   `if x.equals(y)`returns`true`and`y.equals(z)`returns`true`, then`x.equals(z)`must return`true`.

4. **Consistent**: For any non-null reference values x and y,

   multiple invocations of`x.equals(y)`consistently return`true`or consistently return`false`, provided no information used in equals comparisons on the objects is modified.

5. For any non-null reference value x,

   `x.equals(null)`must return`false`.

Do not write equals method on unreliable resources.

#### Steps to writing a high quality`equals`method

* Use the `===`operator to check if the argument is a reference to the object
* Check if the `javaclass `of both the objects are the same
* Cast the argument to the correct type
* Every significant field in the class needs to be checked for logical equality to the corresponding field of the object
* Check if the method obeys symmetry, transitivity and if it is consistent.
* Also, make sure to override the `hashCode `method.

> **In Kotlin, we get all this for free using the`data class`provided by default**

[**Code available here**](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/kotlin/Person.kt)

---

