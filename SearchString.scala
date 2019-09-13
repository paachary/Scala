import java.lang.ArrayIndexOutOfBoundsException

class SearchString (in : Array[String], sW: String, eW: String) {
    
    val startsWith = sW
    val endsWith = eW
    val inputStr = in
    
    override def toString = s"${inputStr} : ${startsWith} : ${endsWith}"
    
    def searchFrom( index : Int) : Int = {
        try {
            if ( index >= inputStr.length ) -1
            else if (inputStr(index).startsWith(startsWith)) searchFrom(index + 1 )
            else if (inputStr(index).endsWith(endsWith)) index
            else searchFrom(index + 1)
        } catch {
            case ex : ArrayIndexOutOfBoundsException => -1
            case ex : Exception => -1
        }
    }
}