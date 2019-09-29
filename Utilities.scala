import java.io.File
import scala.io.Source
import scala.io.Source._
import java.lang.NullPointerException

object Utilities extends App{
       
    private def filePattern (file: File) = fromFile(file).getLines().toList
    
    private def getFiles(path: String = System.getProperty("user.dir")) = (new File(path)).listFiles     
    
    def grepOld(pattern : String) = 
        for ( file <- getFiles()
             if file.getName.endsWith(".scala");
             line <- filePattern(file)
             if line.trim.matches(pattern)
             ) println(s"${file} : ${line.trim}")

    def grep(pattern : String) = 
    for {
        file <- getFiles()
        if file.getName.endsWith(".scala")
            line <- filePattern(file)
            trimmedLine = line.trim
            if trimmedLine.matches(pattern)
    } println(s"${file} : ${trimmedLine}")
    
    def grepWithYield(pattern : String) = 
    for {
        file <- getFiles()
        if file.getName.endsWith(".scala")
        line <- filePattern(file)
        trimmedLine = line.trim
        if trimmedLine.matches(pattern)
    } yield { 
        s"${file} : ${trimmedLine}"
    }
    
    def echo(args: String*) = {
        //for (arg <- args) println(arg)
        args.foreach(println)
    }

    def extractListLastElement(list: List[Any]) : Any = 
        list match {
            case h::Nil => h
            case _::t => extractListLastElement(t)
            case _ =>
        }

    def extractListElements(list: List[Any]) : Unit =
        list match {
            case h :: t => {println(h)
                            extractListElements(t)
            }
            case _ =>
        }

    def isort(xs: List[Int]) : List[Int]=
        xs match {
            case List() => List()
            case x::xs1 => insert(x, isort(xs1))
        }
     
    def insert(x: Int, xs: List[Int]) : List[Int] = 
         xs match {
             case List() => List(x)
             case y :: ys => if (x <= y) x::xs else y :: insert(x, ys)
         }

    def appendList(list1: List[Any], list2: List[Any]) : List[Any] = 
       list1 match {
           case List() =>  list2
           case head :: tl => head :: appendList(tl, list2)
       }
    
    def appendReverseList(list1: List[Any], list2: List[Any]) : List[Any] = {
       val list1_rev = list1.reverse
       val list2_rev = list2.reverse
       appendList(list1_rev, list2 = list2_rev)
    }

     // Old way of writing:
    def fileEndsWithOld(query: String) = 
        for (file <- getFiles(); if file.getName.endsWith(query))
    yield file

    // Old way of writing:
    def fileRegexOld(query: String) = 
        for (file <- getFiles(); if file.getName.matches(query))
    yield file

    // Old way of writing:
    def fileContainsOld(query: String) = 
        for (file <- getFiles(); if file.getName.contains(query))
    yield file
    
    // a slightly better way to write the above repeating apis
    
    private def fileMatching(query : String, matcher: (String, String) => Boolean) = 
        for (file <- getFiles(); if matcher(file.getName, query)) yield file

    def fileEndsWithMatcher(query: String) = 
        fileMatching(query, _.endsWith(_))

    def fileContainsMatcher(query: String) = 
        fileMatching(query, _.contains(_))

    def fileRegexMatcher(query: String) = 
        fileMatching(query, _.matches(_))

    // the most better way to write the above repeating apis
    
    private def fileMatching(matcher: String => Boolean) = 
        for (file <- getFiles(); if matcher(file.getName)) yield file
    
    def fileEndingWith(query: String) = 
        fileMatching(_.endsWith(query))

    def fileContaining(query: String) = 
        fileMatching(_.contains(query))

    def fileRegex(query: String) = 
        fileMatching(_.matches(query))    



    def msort[B](less: (B, B) => Boolean)
        (xs: List[B]): List[B] = {
  
      def merge(xs: List[B], ys: List[B]): List[B] =
        (xs, ys) match {
          case (Nil, _) => ys
          case (_, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (less(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
  
      val n = xs.length / 2
      if (n == 0) xs
      else {
        val (ys, zs) = xs splitAt n
        merge(msort(less)(ys), msort(less)(zs))
      }
    }

    def convertToUpper(string: String) : String = {
        var convertedString: String = ""
        for ( i <- 0 to string.length-1) {
      
          //97 and 122
      
          if ( string(i).toInt >= 97 && string(i).toInt <= 122) {
            convertedString = convertedString+""+(string(i).toInt-32).toChar
          } else {
            convertedString = convertedString + "" + string(i)
          }
        }
        convertedString
      }
      
    def convertToLower(string: String) : String = {
        var convertedString: String = ""
        for ( i <- 0 to string.length-1) {
      
          //65 and 90
      
          if ( string(i).toInt >= 65 && string(i).toInt <= 90) {
            convertedString = convertedString+""+(string(i).toInt+32).toChar
          } else {
            convertedString = convertedString + "" + string(i)
          }
        } 
        convertedString
    } 

    def transformCase( string : String, f : String => String ) : String = {
        f(string)
    } 
    
    def cat = {
        
        val width = args(0).toInt        

        def processFile( fileName: String) = {
            
            def processLine( fileName:String, line:String) = 
                if (line.length > width) println(s"${fileName} : ${line}")    
            
            for (line <- Source.fromFile(fileName).getLines())
                processLine(fileName = fileName, line = line) // named arguments example
        }
        
        for (file <- args.drop(1))
            processFile(fileName = file)
    }

    try {
        require(!args.isEmpty)
        cat
    } catch {
        case ex: java.lang.IllegalArgumentException => println("Usage>> scala Utilities <width_in_integer> <space separated list of files>")
        case ex: java.lang.Exception => println("Please check the usage")
    }       
    
}