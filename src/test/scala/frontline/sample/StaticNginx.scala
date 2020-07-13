package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class StaticNginx extends Simulation {

  
  val httpProtocol = http.baseUrl("http://clapi.rewardthefan.com/")
//  val httpProtocol = http.baseUrl("http://54.198.109.188/")
  

val scn = scenario("5 lac")
  .exec(
    http("HTTP Request")
      .get("http://clapi.rewardthefan.com/staticnginx/")
  ) 

 setUp(scn.inject(atOnceUsers(100000)).protocols(httpProtocol))
}
