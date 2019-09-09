// Java program for printing each element of an array of Strings

import java.util.Arrays;

class JavaComparisonWithScala {
	
    public static void main(String[] args ) {
        String[] greetingsString = new String[3];

        greetingsString[0] = "Hi";
        greetingsString[1] = "Tata";
        greetingsString[2] = "Bye";

        Arrays.stream(greetingsString).forEach(item -> System.out.println(item));

	}
}

// Scala program for printing each element of an array of Strings

val greetStrings = Array("hi","tata","bye bye")
newgreetStrings.foreach(println)



// Java program to declare a class with two variables with a constructor to initialize the variables:

class JavaClass {

    private int index;
    private String name;

    public JavaClass(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public void printString() {
        System.out.println("index = "+ this.index +": name = "+ this.name);
    }
}


class MainJavaClass {
    public static void main(String[] args) {

        JavaClass javaClass = new JavaClass(2,"In Java");
        javaClass.printString();
    }

}
~ 

// Scala program to declare a class with two variables with a constructor to initialize the variables:

class ScalaClass (index :Int, name: String) {
    def printString() = println("index = "+ index +": name = "+ name)
}

object MainScalaClass {
    
    def main(args : Array[String]) = {
        
        scalaClass = new ScalaClass(2,"In Scala")
        
        scalaClass.printString()
    }
}



