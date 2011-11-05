import MyMath._
import Printer._
import Factory._
import javax.swing._
import java.awt.Color
import java.awt.Graphics

import scala.collection.mutable.ListBuffer

class Canvas extends JFrame {

	val base_x = 50
	val base_y = 50
	val default_w = 500
	val default_h = 500

	var lss: List[List[Int]] = null
	var f: Int=>Boolean = isPrime
	var cw = 1
	var ch = 1
	var color = Color.black

	/**
	 * Constructor
	 * @param _lss list of list representing cyclic pattern
	 */
	def this(_lss: List[List[Int]]) = {
		this()
		lss = _lss
		getContentPane().setLayout(new java.awt.FlowLayout())
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
		setTitle("View Frame")
		setSize(default_w, default_h)
		setVisible(true)

		repaint()
	}
	def this(index: Int) = this(create(index))
	
	def setNumber(n: Int) {
		lss = create(n)
//		repaint()
	}
	
	override def paint(g: Graphics) {
		paintPattern(g, f)
	}
	
	private def paintPattern(g: Graphics, f: Int=>Boolean) = {
		g setColor Color.white
		g.fillRect(0, 0, getWidth, getHeight)
		
		g setColor color
		for (wi <- 0 until lss.length ; hi <- 0 until lss(wi).length) {
			if (f(lss(wi)(hi))) {
				val x = wi * cw + base_x
				val y = hi * ch + base_y
				g fillRect (x, y, cw, cw)
			}
		}
	}
	
	def setFunction(f: Int=>Boolean) {
		this.f = f
//		repaint()
	}
	
	override def setSize(w: Int, h: Int) {
		super.setSize(w, h)
//		repaint()
	}
	def setCellSize(w: Int, h: Int) {
		cw = w
		ch = h
//		repaint()
	}
	def setColor(c: Color) {
		color = c
	}
}


object Canvas {
	val maxIndex = 200
	def main(args: Array[String]) {
		val canvas = new Canvas(maxIndex)
	}
}
