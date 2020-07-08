package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class StaticNginx extends Simulation {

  val httpProtocol = http.baseUrl("http://budweiserapi.rewardthefan.com/")

val scn = scenario("My NGINX")
  .exec(
    http("HTTP Request")
      .get("staticnginx/")
  ) 

 setUp(scn.inject(atOnceUsers(300000)).protocols(httpProtocol))
}
