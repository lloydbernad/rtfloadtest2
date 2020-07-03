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

  val httpConf = http
    .baseUrl("https://budweiserapi.rewardthefan.com")

  val scn = scenario("scenario1")
    .exec(
      http("Page 0")
        .get("https://budweiserapi.rewardthefan.com/budweiserapi/TestClientSaaSConfig.json?cuId=lloyd&clId=AMIT202020")
    )
    .exec(
      http("Page 1")
        .get("http://budweiserapi.rewardthefan.com/budweiserapi/TestClientSaaSConfig.json?cuId=tamil&clId=AMIT202020")
    )

  setUp(
    scn.inject(rampUsers(100) during (10 seconds))
  ).protocols(httpConf)
}
