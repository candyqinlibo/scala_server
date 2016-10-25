package controllers

import java.net.InetAddress

object Config {
  val TEST_SERVER = "10.126.45.159"
  val LOCAL_IP = "127.0.1.1"
  val inetAddress = getInetAddress
  val IS_ONLINE = {
    if(getHostIP(inetAddress).equals(TEST_SERVER) || getHostIP(inetAddress).equals(LOCAL_IP)) false
    else true
  }
  val IS_ONLINE_MONGO_SERVER = if(IS_ONLINE) true else false
  
  val ADDRESS_MAIN_INTERNAL = ""
  
  def getHostIP(netAddress:InetAddress) = {
    if(netAddress == null) null
    else netAddress.getHostAddress
  }
  
  def getHostName(netAddress:InetAddress) = {
    if(netAddress == null) null
    else netAddress.getHostName
  }
  
  def getInetAddress = {
    try {
      InetAddress.getLocalHost
    } catch {
      case t: Throwable => t.printStackTrace() // TODO: handle error
      null
    }
  }
}