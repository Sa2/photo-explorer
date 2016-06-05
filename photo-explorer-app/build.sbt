name := """photo-explorer-app"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-io" % "1.3.2"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
