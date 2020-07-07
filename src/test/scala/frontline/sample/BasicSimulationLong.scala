/*
 * Copyright 2011-2018 GatlingCorp (https://gatling.io)
 *
 * All rights reserved.
 */

package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulationLong extends Simulation {

 
  val httpConf = http
    .baseUrl("http://budweiserapi.rewardthefan.com")

  val scn = scenario("http-load")
    .exec(
      http("TestConfig")
        .get("/budweiserapi/TestClientSaaSConfig.json?cuId=lloyd&clId=AMIT202020")
    )
  

  setUp(
    scn.inject(rampUsers(100) during (900 seconds))
  ).protocols(httpConf)
}
