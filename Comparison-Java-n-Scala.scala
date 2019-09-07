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

--------------------------------------------------------
