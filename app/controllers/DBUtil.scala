package controllers

import com.mongodb.casbah._
import com.mongodb.casbah.commons.MongoDBObject

object DBUtil{
//  val mongoConn = MongoConnection()("test")
  val uri:MongoClientURI = MongoClientURI("mongodb://atlantis-admin:Easyroid@ds061375.mongolab.com:61375/atlantis-sandbox")
  val mongoClient = MongoClient(uri)
  val db = mongoClient("atlantis-sandbox")
  val ifInitDone = true
}