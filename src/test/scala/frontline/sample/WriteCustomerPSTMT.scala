/*
 * Copyright 2011-2018 GatlingCorp (https://gatling.io)
 *
 * All rights reserved.
 */

package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class WriteCustomerPSTMT extends Simulation {

  val httpProtocol = http.baseUrl("https://clapi.rewardthefan.com/")

val scn = scenario("DB INSERT-READ")
  .exec(
    http("SAASCONFIG-API")
      .get("budweiserapi/TempTrackingWritePstatmnt.json?cuId=00&clId=DEM2020BUDWEISER0629")
  ) 

 setUp(scn.inject(atOnceUsers(2000)).protocols(httpProtocol))
}
