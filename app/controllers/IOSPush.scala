package controllers
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

object IOSPush {
  val service = 
    if(Config.IS_ONLINE){
      APNS.newService().asPool(15)
          .withCert("./game_push_pub.p12", "")
          .withProductionDestination()
          .build()
    }else{
      APNS.newService().asPool(15)
					.withCert("./game_push_pri.p12", "") 
					.withSandboxDestination()
					.build();
    }
}