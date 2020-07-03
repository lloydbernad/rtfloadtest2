/*
 * Copyright 2011-2018 GatlingCorp (https://gatling.io)
 *
 * All rights reserved.
 */

package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulationLong extends Simulation {

  val httpConf = http
    .baseUrl("http://google.com)

  val scn = scenario("scenario1")
    .exec(
      http("Page 0")
        .get("/")
    )
    .exec(
      http("Page 1")
        .get("/")
    )

  setUp(
    scn.inject(rampUsers(10) during (600 seconds))
  ).protocols(httpConf)
}
