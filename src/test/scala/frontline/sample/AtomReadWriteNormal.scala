/*
 * Copyright 2011-2018 GatlingCorp (https://gatling.io)
 *
 * All rights reserved.
 */

package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AtomReadWriteNormal extends Simulation {

  val httpProtocol = http.baseUrl("https://clapi.rewardthefan.com/")
//livtJoinContestrcpk1rdwr2.json
val scn = scenario("ATOMIC READ WRITE")
  .exec(
    http("ATOMIC READ WRITE")
      .get("budweiserapi/livtJoinContestrcpk1rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259")
  ) 

 setUp(scn.inject(atOnceUsers(1000000)).protocols(httpProtocol))
}
