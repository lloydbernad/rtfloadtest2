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

  val httpProtocol = http.baseUrl("http://budweiserapi.rewardthefan.com/")

val scn = scenario("My Scenario")
  .exec(
    http("My Request")
      .get("budweiserapi/TestClientSaaSConfig.json?cuId=lloyd&clId=AMIT202020")
  ) 
  .exec(
    http("My Other Request")
      .get("budweiserapi/TestClientSaaSConfig.json?cuId=tamil&clId=AMIT202020")
  ) 

  
// setUp(scn.inject(rampUsers(10) during (900 seconds))).protocols(httpConf)
 setUp(scn.inject(atOnceUsers(10000)).protocols(httpProtocol))
  
// setUp(scn.inject(rampUsers(100) during (100 seconds))).protocols(httpConf)

     
}
