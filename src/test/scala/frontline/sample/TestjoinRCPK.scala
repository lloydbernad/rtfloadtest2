/*
 * Copyright 2011-2018 GatlingCorp (https://gatling.io)
 *
 * All rights reserved.
 */

package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class TestjoinRCPK extends Simulation {

  val httpProtocol = http.baseUrl("https://clapi.rewardthefan.com/")

val scn = scenario("JOIN CONTEST RCPK")
  .exec(
    http("JOIN CONTEST RCPK")
      .get("budweiserapi/livtJoinContestRCPK.json?dbctl=0&cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259")
  ) 

 setUp(scn.inject(atOnceUsers(100000)).protocols(httpProtocol))
}
