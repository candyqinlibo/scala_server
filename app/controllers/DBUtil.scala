package controllers

import com.mongodb.casbah._
import com.mongodb.casbah.commons.MongoDBObject

object DBUtil{  
  val uri:MongoClientURI = 
    if(Config.IS_ONLINE) MongoClientURI("mongodb://atlantis-admin:Easyroid@10.0.0.179:27017/atlantis")
    else MongoClientURI("mongodb://atlantis-admin:Easyroid@ds061375.mongolab.com:61375/atlantis-sandbox")
    
  val mongoClient = MongoClient(uri) 
  
  val db = 
    if(Config.IS_ONLINE) mongoClient("atlantis")
    else mongoClient("atlantis-sandbox")
}