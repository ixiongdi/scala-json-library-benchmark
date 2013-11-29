import com.google.caliper._
import org.json4s._






import scala.util.parsing.json._


object Test {


  val ss = scala.io.Source.fromFile("ss.json").mkString
  
  def main(args: Array[String]): Unit = {
    println("-----------Start-----------------")
    jackson
    println("-------------------------------")
    smart
    println("-------------------------------")
    native
    println("-------------------------------")
    // javaee
    println("-----------Stop-----------------")    
  }


  def smart {
    import net.minidev.json.JSONValue
    def test {
      val v = JSONValue.parse(ss)
      v.toString
    }
    val start = System.currentTimeMillis


    MyBenchmark.timeMyOperation(1000, test)


    val stop = System.currentTimeMillis


    println("smart:   " + (stop - start) + "ms")
  }


  def native {
    import org.json4s.native.JsonMethods._


    def test {
      val v = parse(ss)
     render(v)
    }
    val start = System.currentTimeMillis


    MyBenchmark.timeMyOperation(1000, test)


    val stop = System.currentTimeMillis


    println("native:   " + (stop - start) + "ms")
  }


  def jackson {
    import org.json4s.jackson.JsonMethods._
    def test {
      val v = parse(ss)
     render(v)
    }
    val start = System.currentTimeMillis


    MyBenchmark.timeMyOperation(1000, test)


    val stop = System.currentTimeMillis


    println("jackson:  " + (stop - start) + "ms")
  }

  def javaee {
    import javax.json.Json

    def test {
       val jsonReader = Json.createReader(new java.io.StringReader(ss));
       val array = jsonReader.readArray();
       jsonReader.close();
    }
    val start = System.currentTimeMillis


    MyBenchmark.timeMyOperation(1000, test)


    val stop = System.currentTimeMillis


    println("javaee:   " + (stop - start) + "ms")
    
  }


}


object MyBenchmark extends Benchmark {
  def timeMyOperation(reps: Int, f: => Unit) = {
    for (i <- 0 to reps) {
      f
    }
  }
}
