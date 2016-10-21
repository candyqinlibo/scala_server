name := "atlantis-scala-server"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

libraryDependencies += "org.mongodb" %% "casbah"% "3.1.1"

play.Project.playScalaSettings
