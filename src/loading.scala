/**
 * Loading file for painting cyclic pattern in canvas.
 */

// Load math file.
// isPrime(Int) is written in this file.
:load MyMath.scala

// Load pattern factory.
:load Printer.scala
import Factory._

// Load pattern canvas.
:load Canvas.scala

// Create canvas
val num = 150
val c = new Canvas(num)
