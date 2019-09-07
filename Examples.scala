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

