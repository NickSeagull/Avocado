package com.nickseagull.avocado

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._
import spray.json._
import DefaultJsonProtocol._
import MessageProtocol._

class AvocadoServiceActor extends Actor with AvocadoService {
  def actorRefFactory = context

  def receive = runRoute(avocadoRoute)
}

trait AvocadoService extends HttpService {
  val avocadoRoute = {
    path("getMessages") {
      get {
        respondWithMediaType(`application/json`){
          complete(
            if(DatabaseManager.count >= 0){
              DatabaseManager.
                getMessages.
                map(_.toJson.toString).
                toStream

            } else {
              ""
            }
          )
        }
      }
    } ~
    path("sendMessage" / Segment) { message =>
      post {
        DatabaseManager.sendMessage(message)
        complete("Message sent successfully")
      }
    }
  }
}
