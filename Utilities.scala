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