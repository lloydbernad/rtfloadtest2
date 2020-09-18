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

  val httpProtocol = http.baseUrl("https://clapi.rewardthefan.com/")

val scn = scenario("DB INSERT-READ")
  .exec(
    http("SAASCONFIG-API")
      .get("budweiserapi/TempCacheClientSaaSConfig.json?cuId=00&clId=DEM2020BUDWEISER0620")
  ) 

 setUp(scn.inject(atOnceUsers(1500000)).protocols(httpProtocol))
}
