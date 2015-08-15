package com.nickseagull.avocado

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import spray.testkit.ScalatestRouteTest
import spray.http._
import StatusCodes._
import MediaTypes._
import spray.json._
import DefaultJsonProtocol._

class ChatRoomSpec extends FlatSpec with ShouldMatchers with ScalatestRouteTest with AvocadoService {
  def actorRefFactory = system

  "The REST api" should "return an empty list when there are no messages" in {
    Get() ~> avocadoRoute ~> check {
      mediaType should be(`application/json`)
      responseAs[String] should be("[]")
    }
  }

}
