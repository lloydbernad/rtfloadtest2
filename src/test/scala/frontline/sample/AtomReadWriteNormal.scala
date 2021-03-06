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
  
  //livtContValidateAnsrcpk3wr.json
//livtJoinContestrcpk1rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259
//livtJoinContestrcpkcustdb2rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259
//livtJoinContestrcpkcustcache1rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259
//livtContValidateAnsrcpk3wr.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259&ans=A&qNo=1&qId=286&qenck=111111
//livtContValidateAnsrcpk3wr.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259&ans=A&qNo=1&qId=286&qenck=111111
  val scn = scenario("JOIN 1 READ 2 WRITE")
  .exec(
    http("JOIN 1 READ 2 WRITE")
      .get("budweiserapi/livtJoinContestrcpk1rdwr2.json?cuId=00&clId=DEM2020BUDWEISER0629&coId=DEM2020BUDWEISER06291603914063259")
  ) 

 setUp(scn.inject(atOnceUsers(3000000)).protocols(httpProtocol))
}
