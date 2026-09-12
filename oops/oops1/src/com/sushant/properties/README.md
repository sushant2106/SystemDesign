# Compile-Time Polymorphism in Java

## 1. What is Polymorphism?

**Polymorphism** means:

> **One name, many forms.**

`` 
Method name
     +
Number of parameters
     +
Datatype of parameters
     +
Order/position of parameter types
Very Important Comparison
	       Compile-Time	 Runtime
Mechanism	Overloading 	Overriding
Inheritance required?	    No	Usually yes
Methods	Same name, different parameters	Same signature
Decision	Compile time	Runtime
Based on	Reference/argument types	Actual object
Also called	Static/Early binding	Dynamic/Late binding
``
In Java, polymorphism is mainly divided into:

```text
Polymorphism
│
├── Compile-Time Polymorphism
│   └── Method Overloading
│
└── Runtime Polymorphism
    └── Method Overriding
```

This README focuses on **compile-time polymorphism**.

---

# 2. What is Compile-Time Polymorphism?

Compile-time polymorphism is achieved mainly through **method overloading**.

The compiler decides which overloaded method should be called **at compile time**.

Example:

```java
class Calculator {

    void add(int a, int b) {
        System.out.println("int + int");
    }

    void add(double a, double b) {
        System.out.println("double + double");
    }
}
```

Usage:

```java
Calculator c = new Calculator();

c.add(10, 20);
c.add(10.5, 20.5);
```

The compiler determines:

```text
c.add(10, 20)
      ↓
add(int, int)

c.add(10.5, 20.5)
      ↓
add(double, double)
```

Therefore, this is called **compile-time polymorphism**.

---

# 3. Method Overloading

Methods are overloaded when they have:

- The same method name
- Different parameter lists

## Valid Overloading

### Different number of parameters

```java
void show(int x) {
}

void show(int x, int y) {
}
```

### Different parameter types

```java
void show(int x) {
}

void show(double x) {
}
```

### Different parameter order

```java
void show(int x, double y) {
}

void show(double x, int y) {
}
```

---

# 4. What Does NOT Create Overloading?

Changing only the return type is **not enough**.

This is invalid:

```java
class Test {

    int show(int x) {
        return x;
    }

    double show(int x) {
        return x;
    }
}
```

The parameter list is the same:

```text
show(int)
show(int)
```

Java cannot overload methods based only on return type.

---

# 5. How Java Selects an Overloaded Method

When Java sees:

```java
obj.method(argument);
```

the compiler looks for the **most appropriate applicable method**.

For the basic cases, remember this order:

```text
1. Exact Match
       ↓
2. Widening Primitive Conversion
       ↓
3. Boxing / Unboxing
       ↓
4. Varargs
```

This priority is extremely important for understanding overloaded methods.

---

# 6. Case 1 — Exact Match

An exact match is preferred first.

```java
class Test {

    void show(int x) {
        System.out.println("int");
    }

    void show(double x) {
        System.out.println("double");
    }
}
```

Call:

```java
Test t = new Test();

t.show(10);
```

`10` is an `int`.

Therefore:

```text
show(int)    → Exact Match
show(double) → Widening
```

Java chooses:

```text
show(int)
```

Output:

```text
int
```

## Rule

> **Exact match beats conversion.**

---

# 7. Case 2 — Widening

If an exact method does not exist, Java can use primitive widening.

Common widening relationships:

```text
byte
  ↓
short
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

Example:

```java
class Test {

    void show(long x) {
        System.out.println("long");
    }
}
```

Call:

```java
Test t = new Test();

t.show(10);
```

`10` is an `int`.

Java can convert:

```text
int → long
```

This is widening.

Output:

```text
long
```

---

# 8. Exact Match Beats Widening

```java
class Test {

    void show(int x) {
        System.out.println("int");
    }

    void show(long x) {
        System.out.println("long");
    }
}
```

Call:

```java
t.show(10);
```

Candidates:

```text
show(int)  → Exact
show(long) → Widening
```

Winner:

```text
show(int)
```

Output:

```text
int
```

---

# 9. Case 3 — Boxing

Boxing converts a primitive into its wrapper class.

Examples:

```text
int     → Integer
long    → Long
double  → Double
float   → Float
boolean → Boolean
char    → Character
short   → Short
byte    → Byte
```

Example:

```java
class Test {

    void show(Integer x) {
        System.out.println("Integer");
    }
}
```

Call:

```java
Test t = new Test();

t.show(10);
```

Here:

```text
10
↓
int
↓ boxing
Integer
```

Therefore:

```text
show(Integer)
```

is selected.

---

# 10. Widening Beats Boxing

Consider:

```java
class Test {

    void show(long x) {
        System.out.println("long");
    }

    void show(Integer x) {
        System.out.println("Integer");
    }
}
```

Call:

```java
Test t = new Test();

t.show(10);
```

`10` is an `int`.

Two possibilities exist:

```text
int → long
      widening

int → Integer
      boxing
```

Java prefers widening over boxing.

Therefore:

```text
show(long)
```

is selected.

Output:

```text
long
```

Remember:

```text
Exact Match
    >
Widening
    >
Boxing
```

---

# 11. Case 4 — Varargs

Varargs allows a method to accept a variable number of arguments.

Syntax:

```java
void show(int... values) {
}
```

Internally, varargs is treated as an array:

```java
void show(int[] values) {
}
```

You can call it with:

```java
show();
show(10);
show(10, 20);
show(10, 20, 30);
```

Example:

```java
class Test {

    void show(int... values) {
        System.out.println("varargs");
    }
}
```

Call:

```java
Test t = new Test();

t.show(10, 20, 30);
```

The values are collected into an array.

Conceptually:

```text
10, 20, 30
     ↓
int[] {10, 20, 30}
```

---

# 12. Varargs Has Low Priority

Consider:

```java
class Test {

    void show(int x) {
        System.out.println("int");
    }

    void show(int... x) {
        System.out.println("varargs");
    }
}
```

Call:

```java
t.show(10);
```

Possible methods:

```text
show(int)      → Exact Match
show(int...)   → Varargs
```

Java chooses:

```text
show(int)
```

Output:

```text
int
```

Therefore:

```text
Exact
   >
Varargs
```

---

# 13. The Basic Conversion Priority

For the cases in this README:

```text
             Method Call
                  │
                  ▼
           Exact Match?
             /       \
           Yes        No
           │           │
           ▼           ▼
        Select     Widening?
                       / \
                     Yes  No
                      │    │
                      ▼    ▼
                   Select Boxing?
                            / \
                          Yes  No
                           │   │
                           ▼   ▼
                        Select Varargs
```

The simplified priority is:

```text
1. Exact Match
2. Widening
3. Boxing / Unboxing
4. Varargs
```

---

# 14. Case 5 — Ambiguous Overloading

Sometimes Java finds multiple methods that are equally good.

Example:

```java
class Test {

    void show(int x, double y) {
        System.out.println("A");
    }

    void show(double x, int y) {
        System.out.println("B");
    }
}
```

Call:

```java
Test t = new Test();

t.show(10, 10);
```

Analyze the first method:

```text
10 → int       Exact
10 → double    Widening
```

Analyze the second method:

```text
10 → double    Widening
10 → int       Exact
```

Both methods have:

```text
1 Exact
1 Widening
```

Neither is more specific.

Therefore the compiler reports:

```text
reference to show is ambiguous
```

This is a **compile-time error**.

---

# 15. Important Example

Consider:

```java
class Test {

    void show(int x) {
        System.out.println("int");
    }

    void show(long x) {
        System.out.println("long");
    }

    void show(Integer x) {
        System.out.println("Integer");
    }

    void show(int... x) {
        System.out.println("varargs");
    }
}
```

Call:

```java
Test t = new Test();

t.show(10);
```

Analyze:

```text
10 → int
```

Candidates:

```text
show(int)
    ↓
Exact Match

show(long)
    ↓
Widening

show(Integer)
    ↓
Boxing

show(int...)
    ↓
Varargs
```

Winner:

```text
show(int)
```

Output:

```text
int
```

---

# 16. Another Example

```java
class Test {

    void show(long x) {
        System.out.println("long");
    }

    void show(Integer x) {
        System.out.println("Integer");
    }

    void show(int... x) {
        System.out.println("varargs");
    }
}
```

Call:

```java
t.show(10);
```

`10` is `int`.

Possible conversions:

```text
int → long
      Widening

int → Integer
      Boxing

int → int...
      Varargs
```

Priority:

```text
Widening
   >
Boxing
   >
Varargs
```

Therefore:

```text
show(long)
```

is selected.

---

# 17. A Reliable Method for Solving Questions

Whenever you see an overloaded-method question, follow these steps.

## Step 1 — Identify argument types

Example:

```java
t.show(10);
```

Write:

```text
10 → int
```

---

## Step 2 — List all overloaded methods

Example:

```text
show(int)
show(long)
show(Integer)
show(int...)
```

---

## Step 3 — Determine the conversion

```text
show(int)      → Exact
show(long)     → Widening
show(Integer)  → Boxing
show(int...)   → Varargs
```

---

## Step 4 — Compare priorities

```text
Exact
  >
Widening
  >
Boxing
  >
Varargs
```

---

## Step 5 — Select the winner

The highest applicable conversion wins.

---

# 18. Common Primitive Types

Know these primitive types:

```text
byte
short
int
long
float
double
char
boolean
```

Common wrapper classes:

```text
Byte
Short
Integer
Long
Float
Double
Character
Boolean
```

---

# 19. Important Wrapper Relationships

```text
int     → Integer
long    → Long
double  → Double
float   → Float
char    → Character
boolean → Boolean
byte    → Byte
short   → Short
```

Primitive → Wrapper:

```text
Boxing
```

Wrapper → Primitive:

```text
Unboxing
```

Example:

```java
Integer x = 10;  // Boxing

int y = x;       // Unboxing
```

---

# 20. Compile-Time vs Runtime Polymorphism

| Feature | Compile-Time | Runtime |
|---|---|---|
| Main mechanism | Overloading | Overriding |
| Decision | Compile time | Runtime |
| Same class possible? | Yes | Usually inheritance |
| Method signature | Different parameters | Same signature |
| Return type alone | Cannot overload | Covariant return possible |
| Binding | Static/Early binding | Dynamic/Late binding |

Example of compile-time:

```java
void show(int x)
void show(double x)
```

Example of runtime:

```java
class Animal {
    void sound() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog");
    }
}
```

---

# 21. Important Interview Rules

### Rule 1

Same method name + different parameter list:

```text
Overloading
```

### Rule 2

Return type alone cannot overload:

```java
int show(int x)
double show(int x)   // Invalid
```

### Rule 3

Exact match is preferred over widening:

```text
int → int
```

beats:

```text
int → long
```

### Rule 4

Widening is preferred over boxing:

```text
int → long
```

beats:

```text
int → Integer
```

### Rule 5

Varargs generally has the lowest priority among these basic cases.

### Rule 6

If two candidates are equally good:

```text
Ambiguous → Compilation Error
```

---

# 22. Practice Questions

Try to solve these without running the program.

## Question 1

```java
class Test {

    void show(int x) {
        System.out.println("int");
    }

    void show(long x) {
        System.out.println("long");
    }

    void show(Integer x) {
        System.out.println("Integer");
    }

    void show(int... x) {
        System.out.println("varargs");
    }
}

Test t = new Test();

t.show(10);
```

What is the output?

---

## Question 2

```java
class Test {

    void show(long x) {
        System.out.println("long");
    }

    void show(Integer x) {
        System.out.println("Integer");
    }
}

Test t = new Test();

t.show(10);
```

What is the output?

---

## Question 3

```java
class Test {

    void show(float x) {
        System.out.println("float");
    }

    void show(double x) {
        System.out.println("double");
    }
}

Test t = new Test();

t.show(10);
```

What is the output?

---

## Question 4

```java
class Test {

    void show(int x, double y) {
        System.out.println("A");
    }

    void show(double x, int y) {
        System.out.println("B");
    }
}

Test t = new Test();

t.show(10, 10);
```

Does it compile?

---

## Question 5

```java
class Test {

    void show(Integer x) {
        System.out.println("Integer");
    }

    void show(long x) {
        System.out.println("long");
    }

    void show(int... x) {
        System.out.println("varargs");
    }
}

Test t = new Test();

t.show(10);
```

What is the output?

---

# 23. Quick Revision

Remember this mental model:

```text
              OVERLOADING
                   │
                   ▼
          Compiler examines call
                   │
                   ▼
          What is argument type?
                   │
                   ▼
             Exact Match?
              /         \
            Yes          No
             │            │
             ▼            ▼
          SELECT      Widening?
                          │
                          ▼
                       Boxing?
                          │
                          ▼
                       Varargs?
                          │
                          ▼
                  No applicable method
```

The most important basic priority:

```text
EXACT
  ↓
WIDENING
  ↓
BOXING / UNBOXING
  ↓
VARARGS
```

And when two candidates are equally good:

```text
AMBIGUOUS
   ↓
COMPILE-TIME ERROR
```

---

# 24. Learning Roadmap

Study compile-time polymorphism in this order:

```text
01. Method Overloading
        ↓
02. Exact Match
        ↓
03. Primitive Widening
        ↓
04. Boxing
        ↓
05. Unboxing
        ↓
06. Varargs
        ↓
07. Ambiguous Overloads
        ↓
08. Reference Type Overloading
        ↓
09. null with Overloading
        ↓
10. Inheritance + Overloading
        ↓
11. Casting + Overloading
        ↓
12. Constructor Overloading
        ↓
13. Complex Interview Questions
```

---

# 25. Final Cheat Sheet

```text
Compile-Time Polymorphism
        =
Method Overloading

Same method name
        +
Different parameter list
        =
Overloading
```

Basic resolution:

```text
1. Exact Match
2. Widening
3. Boxing / Unboxing
4. Varargs
```

Remember:

```text
Exact > Widening > Boxing > Varargs
```

And:

```text
Return type alone
        ≠
Method Overloading
```

When equally good methods exist:

```text
Ambiguous
   ↓
Compilation Error
```

---

## Goal

You should be able to look at code like:

```java
obj.show(10);
```

and immediately determine:

```text
1. What is the type of 10?
2. Which overloaded methods exist?
3. What conversion is required for each?
4. Which conversion has higher priority?
5. Is there an ambiguity?
6. Which method will the compiler select?
```

