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
  
  val httpProtocol = http.baseUrl("https://budweiserapi.rewardthefan.com")

val scn = scenario("My Scenario")
  .exec(
    http("My Request")
      .get("/budweiserapi/TestClientSaaSConfig.json?cuId=lloyd&clId=AMIT202020")
  ) 
  .exec(
    http("My Other Request")
      .get("https://budweiserapi.rewardthefan.com/budweiserapi/TestClientSaaSConfig.json?cuId=lloyd&clId=AMIT202020")
  ) 

setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

     
}
