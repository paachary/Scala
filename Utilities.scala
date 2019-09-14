import java.io.File
import scala.io.Source
import scala.io.Source._
import java.lang.NullPointerException

object Utilities extends App{
       
    def filePattern (file: File) = fromFile(file).getLines().toList
    
    def getFiles(path: String = System.getProperty("user.dir")) = (new File(path)).listFiles
     
    
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
      
    def cat = {
        val width = args(0).toInt
        
        for (file <- args.drop(1))
            processFile(fileName = file, width = width)
    }

    private def processFile( fileName: String, width: Int) = {
        
        for (line <- Source.fromFile(fileName).getLines()){
            processLine(fileName = fileName, line = line, width = width)
        }  
    }    
    
    private def processLine( fileName:String, line:String, width:Int) = 
       if (line.length > width) println(s"${fileName} : ${line}")    
    
    cat
    
}