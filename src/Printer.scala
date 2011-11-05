import MyMath._

/**
 * 螺旋状の数字のリストを作成
 */
object Factory {
	private def getHidariUe(x: Int): Int =
		if (x == 1) 4
		else getHidariUe(x-1) + 4 + 8*(x-1)
	private def getHidariShita(x: Int): Int =
		if (x == 1) 1
		else getHidariShita(x-1) + (x-1)*8-2
	private def lineNum(index: Int): Int =
		if (index==1) 1
		else if (index==2) 2
		else lineNum(index-1)+2
		
	private def connectedList(left: Int, ls: List[Int], right: Int) =
		(right :: (left :: ls).reverse).reverse

	/**
	 * 螺旋状の数字のリストを作成
	 * @param index 螺旋の周回数
	 * @return 整数のリスト
	 */
	def create(index: Int): List[List[Int]] =
		if (index==1) List(List(4, 3), List(1, 2))
		else {
			val orgls = create(index-1)
			var newls = List[List[Int]]()
			val upper = Range(
				getHidariUe(index) - (2+((index-1)*2)) + 1, 
				getHidariUe(index) + 1
			).toList.reverse
			val lower = Range(
				getHidariShita(index),
				getHidariShita(index) + (2+((index-1)*2))
			).toList
			for (i <- 0 until orgls.length) 
				newls = connectedList(getHidariUe(index-1)+1+i, orgls(i), getHidariUe(index)-(2+((index-1)*2))-i) :: newls
			newls = newls.reverse
			newls = upper :: newls
			newls = (lower :: newls.reverse).reverse
			newls
		}
}

object Printer {
	def printPattern(lss: List[List[Int]], f: Int=>Boolean) =
		for (ls <- lss) {
			for (i <- ls)
				if (f(i)) print("#") else print(" ")
			println
		}
	
	def printPrimePattern(lss: List[List[Int]]) =
		printPattern(lss, (x: Int)=>isPrime(x))

	def printNum(lss: List[List[Int]]) =
		for (ls <- lss) {
			for (i <- ls)
				print(i + ",")
			println
		}
}
