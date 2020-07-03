/*
 * Copyright 2011-2018 GatlingCorp (https://gatling.io)
 *
 * All rights reserved.
 */

package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http.baseUrl("http://google.com")

val scn = scenario("My Scenario")
  .exec(
    http("My Request")
      .get("/")
  ) 
  .exec(
    http("My Other Request")
      .get("http://google.com")
  ) 

  
//setUp(scn.inject(rampUsers(10) during (900 seconds))).protocols(httpConf)
//setUp(scn.inject(atOnceUsers(100)).protocols(httpProtocol))
  
 setUp(
    scn.inject(rampUsers(100) during (100 seconds))
  ).protocols(httpConf)

     
}
