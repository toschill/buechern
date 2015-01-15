name := """buechern"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.xerial" % "sqlite-jdbc" % "3.7.15-M1",
  "org.mindrot" % "jbcrypt" % "0.3m"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)