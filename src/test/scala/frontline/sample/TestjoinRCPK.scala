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

val scn = scenario("JOIN CONTEST RCPK")
  .exec(
    http("JOIN CONTEST RCPK")
      .get("budweiserapi/livtJoinContestRCPK.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259")
  ) 

 setUp(scn.inject(atOnceUsers(1000)).protocols(httpProtocol))
}
