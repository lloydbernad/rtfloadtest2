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
//livtJoinContestrcpkcustdb2rdwr2.json
//livtJoinContestrcpkcustcache1rdwr2.json
val scn = scenario("JOIN READ WRITE")
  .exec(
    http("JOIN READ WRITE")
      .get("budweiserapi/livtJoinContestrcpk1rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259")
  ) 

 setUp(scn.inject(atOnceUsers(2000000)).protocols(httpProtocol))
}
