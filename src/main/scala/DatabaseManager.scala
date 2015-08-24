package com.nickseagull.avocado

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.conversions.scala._

object DatabaseManager {
  val messages = MongoClient("localhost", 27017)("avocado")("messages")
  var messageCount = 0 // This is evil and needs to be changed

  def clear {
    messages.drop()
    messageCount = 0
  }

  def count = messageCount

  def getMessages:List[Message] = {
    messages.find().map(buildMessage).toList
  }

  def sendMessage(m: String) = {
    unsafeInsertMessage(m)
    true
  }

  private def unsafeInsertMessage(m: String) {
    val message = MongoDBObject(
      "_id" -> messageCount,
      "content" -> m
    )
    messageCount+=1 // More evil
    messages.insert(message)
  }

  private def buildMessage(x: DBObject): Message = {
    val id: Int = x.getAs[Int]("_id").getOrElse(-1)
    val content: String = x.getAs[String]("content").getOrElse("")
    Message(id, content)
  }
}
