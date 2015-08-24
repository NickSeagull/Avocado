package com.nickseagull.avocado

import spray.json._
import DefaultJsonProtocol._

case class Message(val id: Int, val content: String)

object MessageProtocol extends DefaultJsonProtocol {
  implicit val messageFormat = jsonFormat2(Message)
}
