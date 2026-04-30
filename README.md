# Basic Integral Solver (Java)

A command-line application written in Java that computes both **definite** and **indefinite integrals** for a variety of common mathematical functions. This project demonstrates the application of calculus rules alongside string parsing and pattern matching techniques in Java.

---

## Features

* Supports **definite integrals** with user-defined bounds
* Supports **indefinite integrals** with symbolic output
* Handles multiple function categories:

  * Exponential functions
  * Trigonometric functions
  * Logarithmic functions
  * Polynomial expressions
  * Constant values
* Implements general integration rules (e.g., chain rule, power rule)
* Includes basic input validation for unsupported formats

---

## Technologies Used

* **Java**
* `java.util.Scanner` for user input
* `java.lang.Math` for mathematical computations
* Regular expressions for parsing input expressions

---

## Getting Started

### Prerequisites

* Java Development Kit (JDK) installed (version 8 or higher recommended)

### Compilation

```bash
javac IntegralSolver.java
```

### Execution

```bash
java IntegralSolver
```

---

## Usage

Upon running the program, the user is prompted to:

1. Select the type of integral:

   * `D` for definite integral
   * `I` for indefinite integral

2. Specify the function category:

   * `e` (Exponential)
   * `t` (Trigonometric)
   * `l` (Logarithmic)
   * `p` (Polynomial)
   * `c` (Constant)

3. Provide the required input:

   * Bounds (for definite integrals)
   * Function expression (with respect to `x`)

---

## Example Usage (Based on Actual Output Format)

### Definite Integral Example

**User Input:**

```text
Enter 'D' for definite integral or 'I' for indefinite integral: D
Is your equation Exponential (e), Trig-based (t), Logarithmic (l), Polynomial (p), or a Constant (c) ?: t
Enter lower bound: 0
Enter upper bound: 3.1415926535
Enter the integrand with respect to 'x': sin(x)
```

**Program Output:**

```text
----------------------------------------------------------------
Input: Definite integral of sin(x) dx, from 0.0 to 3.1415926535
Output: 2.0
----------------------------------------------------------------
Thank you for using Integral Solver!
```

---

### Indefinite Integral Example

**User Input:**

```text
Enter 'D' for definite integral or 'I' for indefinite integral: I
Is your equation Exponential (e), Trig-based (t), Logarithmic (l), Polynomial (p), or a Constant (c) ?: p
Enter the integrand with respect to 'x': 3x^(2)
```

**Program Output:**

```text
----------------------------------------------------------------
Input: Indefinite integral of 3x^(2) dx
Output: 1x^3 + C
----------------------------------------------------------------
Thank you for using Integral Solver!
```

---

## Supported Input Formats

| Function Type | Example Inputs                 |
| ------------- | ------------------------------ |
| Exponential   | `e^x`, `2e^(3x)`               |
| Trigonometric | `sin(x)`, `3cos(2x)`, `tan(x)` |
| Logarithmic   | `ln(x)`, `2ln(3x)`             |
| Polynomial    | `x`, `4x^(3)`, `x^(-1)`        |
| Constant      | `5`, `-3`                      |

---

## Limitations

* Input must strictly follow supported formats
* Limited trigonometric coverage (currently excludes sec, csc, cot)
* Outputs are not algebraically simplified
* No graphical user interface (CLI only)

---

## Future Improvements

* Expand support for additional trigonometric functions
* Improve expression parsing for more flexible input formats
* Implement symbolic simplification
* Enhance error handling and validation
* Develop a graphical user interface

---

## License

This project is open source and available for educational and personal use.
