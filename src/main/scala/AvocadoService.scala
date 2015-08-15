package com.nickseagull.avocado

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

class AvocadoServiceActor extends Actor with AvocadoService {
  def actorRefFactory = context

  def receive = runRoute(avocadoRoute)
}

trait AvocadoService extends HttpService {
  val avocadoRoute = {
    get {
      pathSingleSlash {
        respondWithMediaType(`application/json`) {
          complete("[]")
        }
      }
    }
  }
}
