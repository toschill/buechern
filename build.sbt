name := """buechern"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "postgresql" % "postgresql" % "9.0-801.jdb",
  "org.mindrot" % "jbcrypt" % "0.3m"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)