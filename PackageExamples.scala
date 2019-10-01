package bobsrocket 
    package navigation {
        private [bobsrocket] class Navigator {
        //class Navigator {
            protected[navigation] def useStarChart()  = {}
            class LegOfJourney {
                //private[Navigator] val distance = 100
                val distance = 140
            }
            private[this] val speed = 200
        }
    }

package launch {
    import navigation._
    object Vehicle {
        private[launch] val guide = new Navigator
    }
}


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
