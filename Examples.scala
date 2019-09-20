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

1 + 2 ==> 1.+(2)

1.+(2L) ==> 1+2L

val s="Prashant"
s indexOf "A"
s. indexOf ("A")

s indexOf ("A",4)

-2.0
(2.0).unary_-

import scala.language.postfixOps

s toLowerCase


def getFiles = (new File(System.getProperty("user.dir"))).listFiles

for (line <- getFiles) println(line.getName.endsWith(".scala"))

for (line <- getFiles; if line.getName.endsWith("scala")) println(line)


for (line <- Utilities.grepWithYield(".*gcd.*")) println(line)


//////

import java.lang.ArrayIndexOutOfBoundsException
import java.lang.Exception

val inputStr = Array("Prashant","-something.scala","somethingelse.scala")
val searchString = new SearchString(inputStr, "-",".scala")

try {
    println(inputStr(searchString.searchFrom(0)))
} catch {
    case ex : ArrayIndexOutOfBoundsException => println("Pattern not found in the input string")
    case ex : Exception => ex.printStackTrace
}


// imperative style programing multiplication table:

def printMultiTable() = {
    var i = 1
    // only i in scope here
    while (i <= 10) {
        var j = 1
        // both i and j in scope here
        while (j <= 10) {
            val prod = (i * j).toString
            // i, j, and prod in scope here
            var k = prod.length
            // i, j, prod, and k in scope here
            while (k < 4) {
                print(" ")
                k += 1
                }
            print(prod)
            j += 1
        }
        // i and j still in scope; prod and k out of scope
        println()
        i += 1
        // i still in scope; j, prod, and k out of scope}
    }
}


/// functional style programing for multiplication table

// Returns a row as a sequence
def makeRowSeq(row: Int) =
for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
}

// Returns a row as a string
def makeRow(row: Int) = makeRowSeq(row).mkString

// Returns table as a string with one row per line
def multiTable() = {
    val tableSeq = // a sequence of row strings
    for (row <- 1 to 10) 
        yield makeRow(row)    
    tableSeq.mkString("\n")
}

Utilities.echo("hello","world","one")

Utilities.echo()

val arr = Array("that's","up","doc")
//-----------------------
Utilities.echo(arr:_*)
                      ^
       warning: Passing an explicit array value to a Scala varargs method is deprecated (since 2.13.0) and will result in a defensive copy; Use the more efficient non-copying ArraySeq.unsafeWrapArray or an explicit toIndexedSeq call
that's
up
doc
//-----------------------

val arr =scala.collection.immutable.IndexedSeq("that's","up","doc")

Utilities.echo(arr:_*)
that's
up
doc

//-----------------------

for (line <- Utilities.fileEndsWithOld("class")) println(line)

for (line <- Utilities.fileEndsWithMatcher("class")) println(line)

for (line <- Utilities.fileContainsMatcher("Class")) println(line)

for (line <- Utilities.fileContaining("Class")) println(line)


//Curried Functions

//---------
def curriedSum(x : Int)(y: Int) = x+y
curriedSum: (x: Int)(y: Int)Int

curriedSum(2)(4)
res0: Int = 6

//---------
def firstFun(x:Int) = (y: Int) => x+y
firstFun: (x: Int)Int => Int

val secondOne = firstFun(3)
secondOne: Int => Int = $$Lambda$799/1597425891@4da39ca9

secondOne(4)
res1: Int = 7
//---------

// For instance, while both classes extend from Writer, and both can be used for writing plain text to files, 
// FileWriter throws IOExceptions, whereas PrintWriter does not throw exceptions, and instead sets Boolean flags that can be checked.

// PrintWriter
import java.io.{File,PrintWriter,FileWriter}

val pw = new PrintWriter(new File("hello.txt" ))
try {
    pw.write("Hello, world\n")
    pw.println("writing new lines")
} finally {
    pw.close()
}


// loan pattern -> opens a resource and loans it to the caller program. Caller program doesnt need to bother with ensuring the resources being taken (read as closing)
// care once job done.
/*
import java.io.{File,PrintWriter,FileWriter}


def withPrintWriter(file: File, op: PrintWriter => Unit) = {
    val pw = new PrintWriter(new FileWriter(file,true)) // for appending into an existing file if it exists already
    
    try {
        op(pw)
    }
    finally {
        pw.close()
    }
}
*/

// Using currying functions
import java.io.{File,PrintWriter,FileWriter}

def withPrintWriter(file: File) (op: PrintWriter => Unit) = {
    val pw = new PrintWriter(new FileWriter(file,true)) // for appending into an existing file if it exists already
    
    try {
        op(pw)
    }
    finally {
        pw.close()
    }
}

val arr = Array("writing this into a new file-2","trying out something-2", "let's c-2")

/*
withPrintWriter(new File("hello1.txt"),
                pw => arr.foreach(pw.println)
                )
*/

// Using currying functions
val file = new File("hello1.txt")
withPrintWriter(file) {writer => arr.foreach(writer.println)}

// FileWriter
val file = new File(canonicalFilename)
val bw = new BufferedWriter(new FileWriter(file))
bw.write(text)
bw.close()

val myqueue = new BasicIntQueue with Doubling // using the required trait directly when defining an instance of a class
myqueue.list
myqueue.put(2)

val newqueue = (new BasicIntQueue with Incrementing with Doubling with Filtering) // order of mixins follows a rule:
                                    // traits further to the right take effect first

val newqueue1 = (new BasicIntQueue with Doubling with Incrementing)