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
  
  private val httpConf = http.baseURL("https://budweiserapi.rewardthefan.com").acceptHeader("application/json")
  private val scn: ScenarioBuilder = scenario("Initial Scenario").exec(http("Get all posts").get("/budweiserapi/TestClientSaaSConfig.json?cuId=lloyd&clId=AMIT202020"))

  setUp(
    scn.inject(atOnceUsers(100))
  ).protocols(httpConf)
     
}
