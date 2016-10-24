package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import com.mongodb.casbah.commons.MongoDBObject
import play.mvc.Http.RequestHeader

object Application extends Controller {

  val resultWhenJsonIsNull:String = "{\"code\":1}"
  
  
  def index = Action {
    Ok("ready!")
  }

  def hello = Action { implicit request =>
    println(request.headers.get(CONTENT_TYPE))
    val jsonBody: Option[JsValue] = request.body.asJson
    if(jsonBody == null){
      Ok(resultWhenJsonIsNull)
    }
    Ok(Handler.healthCheck(jsonBody))
  }
  
  def healthCheck = Action {
    Ok(views.html.index.render("Your new application is ready."))
  }
  
  def GoToStore = Action { implicit request =>
    var result = "https://play.google.com/store/apps/details?id=com.atlantis.game.tdctdh";
		val agent = request.headers.get(USER_AGENT)
		val keywords = Array("iPhone","iPod","iPad")
		if(!agent.get.contains("Windows NT") || agent.get.contains("compatible; MSIE 9.0;") 
		    && agent.get.contains("Windows NT")){
		  if(!agent.get.contains("Windows NT") && !agent.get.contains("Macintosh")){
		    for(v <- keywords){
		      if(agent.get.contains(v)){
		        result = "https://itunes.apple.com/app/id1087289683"
		      }
		    }
		    if(agent.get.contains("Android")){
		      result = "https://play.google.com/store/apps/details?id=com.atlantis.game.tdctdh"
		    }
		  }
		}
		Redirect(result)
  }
}