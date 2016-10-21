package controllers

object Config {
  def IS_ONLINE = true
  def IS_ONLINE_MONGO_SERVER = if(IS_ONLINE) true else false
  def ADDRESS_MAIN_INTERNAL = ""
}