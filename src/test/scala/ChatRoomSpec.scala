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

  "The REST api" should "return an empty list on GET when there are no messages" in {
    DatabaseManager.clear
    Get("/getMessages") ~> avocadoRoute ~> check {
      responseAs[String] should be("")
    }
  }

  it should "be able to POST a message" in {
    DatabaseManager.clear
    Post("/sendMessage/message") ~> sealRoute(avocadoRoute) ~> check {
      responseAs[String] should be("Message sent successfully")
    }
  }

  it should "return a list of messages containing the message that was POSTed" in {
    DatabaseManager.clear
    Post("/sendMessage/message") ~> sealRoute(avocadoRoute) ~> check {
      responseAs[String] should be("Message sent successfully")
    }
    Get("/getMessages") ~> avocadoRoute ~> check {
      responseAs[String] should be("{\"id\":0,\"content\":\"message\"}")
    }
  }


}
