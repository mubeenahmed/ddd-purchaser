import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import product.endpoint.rest.product.ProductRestApi

import scala.concurrent.ExecutionContext

object Server {

  val host = "0.0.0.0"
  val port = 9000


  implicit val system: ActorSystem = ActorSystem("purchaser")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  def main(args: Array[String]): Unit =
  {
    val route = ProductRestApi.route
    Http().bindAndHandle(route, host, port)
    println(s"Port bind on IP address ${host} and port ${port}")
  }
}
