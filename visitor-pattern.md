## 🎯 Goals Achieved by Implementing the Visitor Pattern

### 1. Add New Operations Without Changing Classes
You can add new functionality to existing class hierarchies without modifying the classes themselves.  
This keeps your code **closed for modification, but open for extension** (a core principle of SOLID design).

### 2. Separate Algorithms from Object Structures
It cleanly separates the **data (object structure)** from the **logic (algorithms/operations)**.  
This is useful when you need to apply many unrelated operations to the same set of objects.

### 3. Promotes Single Responsibility Principle
The data classes (like `Body`, `Engine`) don't need to know about the various operations.  
**Visitors** handle the logic, making the system more **modular and maintainable**.

### 4. Enables Double Dispatch
Normally, Java only does **single dispatch** (method call based on the object’s runtime type).  
The Visitor pattern enables **double dispatch**, where both the element type and the visitor type are used to determine which method gets executed.  
This allows more precise behavior based on **both object and operation**.

---

## Problems It Solves in Modern OOP

| Problem                                                             | How Visitor Helps                                       |
|---------------------------------------------------------------------|----------------------------------------------------------|
| You have many classes and want to perform unrelated operations      | Add new operations by just adding a new Visitor class    |
| Adding behavior requires modifying many classes                     | No need to touch original classes — just extend visitor  |
| Poor separation between data and logic                              | Visitor keeps logic separate from data structures        |
| Code duplication across multiple classes                            | Centralize operations inside visitors                    |
| Want to avoid bloating classes with rarely-used functionality       | Move that logic into specific visitor implementations    |

---

## Limitations to Consider

| Limitation                                          | Description                                                             |
|-----------------------------------------------------|-------------------------------------------------------------------------|
| Not ideal if the object structure changes frequently | Adding new `Element` types requires updating all `Visitor` classes      |
| Can be overkill for small/simple projects           | Adds complexity with interfaces and boilerplate                         |

---

## Real-World Use Cases

- **Compilers/Interpreters** – walking an abstract syntax tree (AST)
- **Document Processing** – performing operations on elements of a document
- **GUI Libraries** – rendering or serializing UI components
- **Code Generation Tools** – converting structures into code/text

## Summary

| Feature               | Benefit                                               |
|----------------------|--------------------------------------------------------|
| **Extensibility**     | Add new operations easily                              |
| **Separation of concerns** | Keep operations out of data classes              |
| **Maintainability**   | Cleaner and more modular logic                         |
| **Double Dispatch**   | Enable dynamic method resolution based on both types  |
