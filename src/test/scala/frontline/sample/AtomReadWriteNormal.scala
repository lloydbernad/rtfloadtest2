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
//livtJoinContestrcpk1rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259
//livtJoinContestrcpkcustdb2rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259
//livtJoinContestrcpkcustcache1rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259
//livtContValidateAnsrcpk3wr.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259&ans=A&qNo=1&qId=286&qenck=111111
//livtContValidateAnsrcpk3wr.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259&ans=A&qNo=1&qId=286&qenck=111111
  val scn = scenario("VAL ANS READ WRITE")
  .exec(
    http("VAL ANS READ WRITE")
      .get("budweiserapi/livtJoinContestrcpk1rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259")
  ) 

 setUp(scn.inject(atOnceUsers(2000000)).protocols(httpProtocol))
}
