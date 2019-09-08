val greetStrings = Array("hi","tata","bye bye")
newgreetStrings.foreach(println)

val newgreetStrings = new Array[String](3)

newgreetStrings.update(0, "hi") // ==> newgreetStrings(0) = "hi"

newgreetStrings.update(1, "bye") // ==> newgreetStrings(1) = "bye"

newgreetStrings.update(2, "tata") // ==> newgreetStrings(2) = "tata"

newgreetStrings.apply(2) // ==> newgreetStrings(2)

newgreetStrings.foreach(println)

// Concatenation of lists:

val thrill = "Will" :: "fill" ::"Until" :: Nil
thrill: List[String] = List(Will, fill, Untill)

val oneTwoThreeFour = oneTwo ::: threeFour :: List(1)
oneTwoThreeFour: List[Any] = List(1, 2, List(3, 4), 1)

val oneTwoThreeFour = (oneTwo ::: threeFour) :: List(1)
oneTwoThreeFour: List[Any] = List(List(1, 2, 3, 4), 1)

val oneTwoThreeFour =  1 :: oneTwo ::: threeFour
oneTwoThreeFour: List[Int] = List(1, 1, 2, 3, 4)

// Tuples:

 val pair =  (99, "My Tuple")
pair: (Int, String) = (99,My Tuple)

scala>

scala> pair._1
res33: Int = 99

scala> pair._2
res34: String = My Tuple

 def formatArgs(arg : Array[String]) = arg.mkString("\n")
formatArgs: (arg: Array[String])String

formatArgs(Array("Bangalore","Chennai","Culcutta"))
res86: String =
Bangalore
Chennai
Culcutta

 val res = formatArgs(Array("Bangalore","Chennai","Calcutta"))
 assert(res == "Bangalore\nChennai\nCalcutta")


 def processFile(args : Array[String]) =
 {
    if (args.length > 0 )
    Source.fromFile(args(0)).getLines().foreach(a -> println(a.lenght))
    else
    Console.err.println("Please enter a file name")
 }
 
 
import scala.io.Source

def processFilenPrint(args : Array[String]) = {
    def widthOfLength(s: String) = s.length.toString.length
    if (args.length > 0) {
        val lines = Source.fromFile(args(0)).getLines().toList
        val longestLine = lines.reduceLeft(
        (a, b) => if (a.length > b.length) a else b
        )
        val maxWidth = widthOfLength(longestLine)
        for (line <- lines) {
            val numSpaces = maxWidth - widthOfLength(line)
            val padding = " " * numSpaces
            println(padding + line.length + " | " + line)
        }
    }
    else
        Console.err.println("Please enter filename")
}


import ChecksumAccumulator.calculate
object Summer {

    def main(args: Array[String]) = {
        for (arg <- args)
            println(arg + ": " + calculate(arg))
    }
}

