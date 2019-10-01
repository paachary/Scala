class ScalaClass (index :Int, name: String) {
  println("in the constructor of the class")

  def printString() = println("index = "+ index +": name = "+ name)
}

object MainScalaClass {
    
    def main(args : Array[String]) = {
        
        val scalaClass = new ScalaClass(2,"In Scala")
        
        scalaClass.printString()        
    }
}
