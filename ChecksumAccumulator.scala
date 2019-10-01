class ChecksumAccumulator {
    private var sum = 0
    def add(b: Byte): Unit = { sum += b }
    def checksum(): Int = ~(sum & 0xFF) + 1
}

import scala.collection.mutable
object ChecksumAccumulator {

	private val cache = mutable.Map.empty[String, Int]

	def calculate(s: String): Int =

	if (cache.contains(s)) cache(s)
	else {

		val acc = new ChecksumAccumulator

		for (c <- s)
			acc.add(c.toByte)

		val cs = acc.checksum()
		cache += (s -> cs)
		cs

	}
}

import ChecksumAccumulator.calculate

object Summer {

    def main(args: Array[String]) = {
        for (arg <- args)
            println(arg + ": " + calculate(arg))
    }
}

import ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {

  for ( list <- args ) 
    println(list + ":" + calculate(list))
}
