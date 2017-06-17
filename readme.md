# Effective Kotlin

[![codebeat badge](https://codebeat.co/badges/55c838ce-608d-4eeb-a706-36117513f1a7)](https://codebeat.co/projects/github-com-narenkmanoharan-effective-kotlin-master)

Kotlin implementation of the effective java items from [Effective Java](https://www.amazon.com/Effective-Java-2nd-Joshua-Bloch/dp/0321356683) book by Joshua Block.


### Table of Contents

1. [Static Factory Methods](#static-factory-methods)
2. [Builder Pattern](#builder-pattern)
3. [Singleton Pattern](#singleton-pattern)
4. [Private Constructors](#private-constructors)
5. [Avoid creating unnecessary objects](#avoid-creating-unnecessary-objects)
6. [Eliminate Obsolete Object References](#eliminate-obsolete-object-references)
7. [Avoid finalizers](#avoid-finalizers)
8. [Overriding Equals](#overriding-equals)
9. [Overriding Hashcode](#overriding-hashcode)
10. [Overriding toString](#overriding-tostring)
11. [Cloning Objects](#cloning-objects)
12. [Implementing Comparable and Using Comparators](#implementing-comparable-and-using-comparators)
13. [Class and Member accessibility minimization](#class-and-member-accessibility-minimization)

--- 

## Static Factory Methods

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

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Car.kt)**

--

## Builder Pattern

This pattern is used when designing classes whose constructors may have more than a handful of parameters. They also simulate the behavior of named optional parameters which are available in Kotlin. 

In most cases you don't need to use builders in Kotlin because we have default and named arguments. But, it is nice to have.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Vacation.kt)**

--

## Singleton Pattern

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

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Database.kt)**

--

## Non-instantiability using Private Constructors

In order to ensure non-instantiability of a class, a private constructor might come in handy. Using this we can make sure that we only instantiate the class when absolutely required using a factory or builder pattern.

#### Cases

- To prevent instantiation outside of the object in
    - Singleton
    - Factory Method
    - Static-methods-only (utility) class
    - Constants-only class

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Burger.kt)**

--

## Avoid creating unnecessary objects

Be careful when creating objects to make sure to reuse objects when possible. This can be done by the use of the init method available in Kotlin to initialize an object whenever the class is initialized, rather than having it be created every time a method is called on an instance. This helps with better performance and memory consumption.

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Pizza.kt)**

--

## Eliminate Obsolete Object References

Memory leakage is a serious issue that we need take care of in both Java and Kotlin which can easily lead to an OutOfMemoryError if not carefully dealt with. Also it might adversely affect the performance of the program by increased garbage collector activity or increased memory footprint. 

This can be nulling out references that you don't need anymore. But this should be an exception rather than a norm.

#### Sources of Memory leaks

- Whenever a class manages its own memory, the programmer should be alert for memory leaks
- Memory leaks in Cache
- Another source is listeners and other callbacks (Specifically callbacks in Android whether be it Asynctasks or OnClickListeners)

--

## Avoid finalizers

Finalize() in Kotlin which is usually called with Java is not guaranteed to be called when declared and so anything time sensitive should never be done in them. They are unpredictable and exhibit erratic behavior. Finalize is not synonymous to destructors in C++. Also System.gc and System.runFinalization.

Also there is severe performance penalty for using finalizers.  

--

## Overriding Equals

Don't override the equals method if 

- Each instance of the class is inherently unique
- Superclass has overridden equals method
- When the package is private 

```
  override fun equals(other: Any?): Boolean {
        throw AssertionError() // Method is never called}
```

Override the equals method if

- Logical equality is important

Equals method implements an equivalence relation:

1. **Reflexive**: For any non-null reference value x,

    ` x.equals(x)` must return `true`
    
2. **Symmetric**: For any non-null reference values x and y,

    `x.equals(y)` must return `true` if and only if `y.equals(x)` returns `true`.
    
3. **Transitive**: For any non-null reference values x, y, z, 

    `if x.equals(y)` returns `true` and `y.equals(z)` returns `true`,               then `x.equals(z)` must return `true`.
    
4. **Consistent**: For any non-null reference values x and y, 

    multiple invocations of `x.equals(y)` consistently return `true` or consistently return `false`, provided no information used in equals comparisons on the objects is modified.

5. For any non-null reference value x, 

    `x.equals(null)` must return `false`.
    

Do not write equals method on unreliable resources.


#### Steps to write a high quality `equals` method

- Use the `===` operator to check if the argument is a reference to the object
- Check if the `javaclass` of both the objects are the same
- Cast the argument to the correct type
- Every significant field in the class needs to be checked for logical equality to the corresponding field of the object
- Check if the method obeys symmetry, transitivity and if it is consistent.
- Also make sure to override the `hashCode` method.


**In Kotlin, we get all this for free using the `data class` provided by default**
    
**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Person.kt)**

--

## Overriding Hashcode

There is a rule to always override `hashCode` whenever `equals` is overridden. If this is not obeyed, then this would result in a violation of the contract of the Object.hashCode method and will prevent the class from functioning properly in conjunction with all the has-based collections.

The vital part of writing the `hashCode` method relies on the fact that **equal objects must have equal hash codes**. A good hashCode should always produce different hashcodes for unequal objects.

#### Steps to write a high quality `hashCode` method

- Store a constant non zero value calculated from any attribute of the class using it's superclass method

```
var result = fName.hashCode()
```

- For each significant field f (All field defined in the `equals` method), do the following

    - Compute an `Int hashCode c` for the field
        
        - Boolean: `f ?: 0`
        - Byte, Char, Short, Float, Double, Int: `f.toInt()`
        - Long: `(f ^ (f >>> 32)).toInt()`
        - The class's `equals` method compares the field by recursively invoking equals and invoke the `hashCode` on the field.
        - Array: Each element is treated as a separate field by applying the rules recursively.

**In Kotlin, we get all this for free using the `data class` provided by default**

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Person.kt)**

--

## Overriding toString

A good `toString` implementation makes the class much more pleasant to use. It clearly displays the most significant information required in a class object. If the `toString` method is not overridden, then printing the object would returns the class name followed by the unsigned hexadecimal representation of the hashcode.

If there is a specific format of the `toString` then mention them in the documentation. If not then make a specific comment about the `toString` method. 

Also provide programmatic access to all the information contained in the value returned by `toString`.

**In Kotlin, we get all this for free using the `data class` provided by default**

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Person.kt)**

--

## Cloning Objects

Cloning in kotlin is as easy as calling the copy method from the data class. The method provided by the data class offers the following:

```
- x.copy() !== x
- x.javaClass == x.copy().javaClass
- x.copy().equals(x)
```

This method provided by Kotlin itself, satisfies all the requirements that are requested by the contract of implementing the Cloneable interface in Java to expose the protected clone() method in the object class.

And in this method we could also provide named arguments as to what should be different from the data class it is cloned from. The data class in kotlin uses the copy constructor approach from java to implement it's cloning facility.

It uses a copy constructor and a static factory which provides a lot more robustness over implementing the cloneable interface. Such as

- Doesn't rely on a risk-prone extralinguistic object creation mechanism
- Doesn't demand unenforceable adherence to not-so documented conventions
- Doesn't conflict with vals
- Doesn't throw checked exceptions
- Doesn't require casts
- Add interface like functionality since Cloneable doesn't have a public `clone` method


**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Sheep.kt)**

-- 

## Implementing Comparable and Using Comparators

Implementing the comparable interface in the class provides a "natural" way of ordering the objects created by the class. The `compareTo` method provided by the comparable interface is used to sort the collection in the way specified. The general contract of the `compareTo` method is similar to that of the `equals` method. 

- Compare `this` object with the other object provided
- Returns a negative integer if the object is less than the object it is compared to.
- Returns zero if they are equal
- Returns a positive integer if the object is greater than the object it is compared to.
- Throws `ClassCastException` if the specified object's type prevents it from being compared to this object.

The contract specification goes as follows

```
- x.compareTo(y) == -y.compareTo(x) for all x and y
- Transitivity: (x.compareTo(y) > 0 && y.compareTo(z) > 0)
- if x.compareTo(y) == 0, then x.compareTo(z) == y.compareTo(z) 
- Recommendation: (x.compareTo(y) == 0) == (x.equals(y))

```

#### `compareBy` using Comparator

The `compareBy` function available in Kotlin is used to sort an object with multiple fields with the use of comparators and method references. This creates a comparator using the sequence of functions to calculate a result of comparison. This is called in the sequence that we need the list to be ordered.

```
// Using the it operator
val sortedListOfMovies: List<Movies> = list.sortedWith(compareBy({ it.rating }, { it.year }))

// Using method references 
val sortedListOfMovies: List<Movie> = moviesList.sortedWith(compareBy(Movie::rating, Movie::year))
```

**[Code available here](https://github.com/narenkmanoharan/Effective-Kotlin/blob/master/src/main/Movie.kt)**

-- 

## Class and Member accessibility minimization

#### Rule of thumb: Make each class or member as inaccessible as possible.

Kotlin helps in this regard by making every class uninheritable by default. So, in order to make a class support inheritance, we need to mention `open class` to enable it.

Also instance fields should always be private and preferred to be immutable to make sure that it is thread-safe.

And there are four specific access specifiers

1. private
2. package-private
3. protected
4. public

#### Dealing with arrays and Static Fields

When dealing with arrays in accessor fields make sure that  you either return a copy of the array or an immutableList that cannot be changed.
It is important that the user does not tamper with the references.

Ensure that the Public API that you build has only constant static fields as the only available public fields. 

The data class in kotlin provides us with all the necessary tools under the hood to achieve all this with just the keyword.

**[Code available here]()**

-- 


