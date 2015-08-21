package com.nickseagull.avocado

import com.mongodb.casbah.Imports._

object DatabaseManager {
  val mongoClient = MongoClient("localhost", 27017)
  val database = mongoClient("avocado")
  val messages = database("messages")

  def clear {
    messages.drop()
  }

  def getMessages = {
    List()
  }
}
