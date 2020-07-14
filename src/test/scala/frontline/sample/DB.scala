/*
 * Copyright 2011-2018 GatlingCorp (https://gatling.io)
 *
 * All rights reserved.
 */

package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class DB extends Simulation {

  val httpProtocol = http.baseUrl("http://clapi.rewardthefan.com/")

val scn = scenario("DB")
  .exec(
    http("HTTP Request")
      .get("budweiserapi/GetClientSaaSConfig.json?cuId=00&clId=DEM2020BUDWEISER0620")
  ) 

 setUp(scn.inject(atOnceUsers(100000)).protocols(httpProtocol))
}
