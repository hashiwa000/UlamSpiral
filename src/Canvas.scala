import MyMath._
import Printer._
import Factory._
import javax.swing._
import java.awt.Color
import java.awt.Graphics

import scala.collection.mutable.ListBuffer

/**
 * ������`�悷��N���X
 * @auther Masatoshi TAKAMIYA
 */
class Canvas extends JFrame {

	val baseX = 50		// �͗l�̉E���x���W
	val baseY = 50		// �͗l�̉E���y���W
	val defaultW = 500	// �E�B���h�E�̕�
	val defaultH = 500	// �E�B���h�E�̍���

	var lss: List[List[Int]] = null	// ������ƂȂ��Ă��鐔��
	var f: Int=>Boolean = isPrime	// �`�悷�邩�ǂ����𔻕ʂ���֐�
	var cw = 1						// �`�悷�镝
	var ch = 1						// �`�悷�鍂��
	var color = Color.black			// �`�悷��F

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
		setSize(defaultW, defaultH)
		setVisible(true)

		repaint()
	}
	def this(index: Int) = this(create(index))

	/**
	 * 
	 */
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
				val x = wi * cw + baseX
				val y = hi * ch + baseY
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
