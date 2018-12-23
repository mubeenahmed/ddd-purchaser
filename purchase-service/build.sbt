name := "purchaser"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.13",
  "com.typesafe.akka" %% "akka-stream" % "2.5.13",
  "com.typesafe.akka" %% "akka-http" % "10.1.3",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.5",
  "io.bfil" %% "automapper" % "0.6.1",
  "com.typesafe.slick" %% "slick" % "3.2.3",
  "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
  "org.apache.kafka" %% "kafka" % "0.10.1.1"
)