//scalac TestPackage.scala 
//TestPackage.scala:3: error: class Navigator in package navigation cannot be accessed in package bobsrocket.navigation
//val navigate = new Navigator
//                       ^
//one error found

import bobsrocket.navigation._
class TestPackage {
    val navigate = new Navigator

    val legOfJourney = new navigate.LegOfJourney

    override def toString= " "+legOfJourney.distance

}
