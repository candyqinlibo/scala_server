package controllers

import play.api.libs.json.JsValue
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.MongoCollection

object Handler {
  def hello(json:Option[JsValue]):String = {
    val resultDoc = MongoDBObject("code" -> 0,"mes"->0)
    resultDoc.toString()
  }
  
  def healthCheck(json:Option[JsValue]):String = {
    val userDataCollection:MongoCollection = DBUtil.db("_User")
//    println("number of the users = " + userDataCollection.count().toInt)
    val resultDoc = MongoDBObject("code" -> json.get.\("userID").as[String])
    resultDoc.toString()
  }
  
  def Statistics(json:Option[JsValue]):String = {
    "a"
  }
  
}