import java.io.File
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
}