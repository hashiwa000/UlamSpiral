//package util

object MyMath {
	
	/**
	 * 再帰的に素数かどうかを判定する関数。
	 * @param x 判定対象の数
	 * @param y 割り切れるかどうかを確認している数
	 */
	private def isPrimeTmp(x: Int, y: Int): Boolean =
		if (x/2<y) true else if (x%y==0) false else isPrimeTmp(x, y+1)
		
	/**
	 * 素数判定関数
	 * @param x 判定対象の数
	 */
	def isPrime(x: Int): Boolean =
		if (x<=1) false
		else isPrimeTmp(x, 2)
		
	def printPrime(min: Int, max: Int) =
		for (i <- min until max) if (isPrime(i)) print(i + ", ")
		
	private def isFibTmp(x: Int, n1: Int, n2: Int): Boolean =
		if (x==n1) true
		else if (x < n1) false
		else isFibTmp(x, n1+n2, n1)
	def isFib(x: Int) = if (x < 1) false else isFibTmp(x, 1, 1)
}
