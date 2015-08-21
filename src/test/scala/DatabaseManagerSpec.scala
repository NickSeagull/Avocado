package com.nickseagull.avocado

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

/*
 TODO:
 - Return empty list when there are no messages
 - Return true when message was inserted, it has to have:
 --> ID
 --> Date
 --> Content
 - Return false when it was impossible to insert message
 - Return list of messages
 - Return a message selected by ID
 */

class DatabaseManagerSpec extends FlatSpec with ShouldMatchers {
  "The DatabaseManager" should "return an empty list when no messages" in {
    DatabaseManager.clear
    DatabaseManager.getMessages should be(List())
  }
}
