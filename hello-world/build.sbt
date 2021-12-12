name := "hello-akka"
version := "0.1"
scalaVersion := "2.13.1"

lazy val akkaVersion = "2.6.3"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
)