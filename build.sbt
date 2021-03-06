// -*- scala -*-

name := "scala-irc-bot"

organization := "net.mtgto"

version := "0.1.0"

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.1", "2.9.2")

resolvers += "twitter repos" at "http://maven.twttr.com"

libraryDependencies := Seq(
  "pircbot" % "pircbot" % "1.5.0",
  "com.twitter" % "util-eval" % "5.3.10",
  "ch.qos.logback" % "logback-classic" % "1.0.7",
  "junit" % "junit" % "4.10" % "test",
  "org.specs2" %% "specs2" % "1.12.1" % "test"
)

scalacOptions ++= Seq("-deprecation", "-unchecked", "-encoding", "UTF8")

unmanagedBase in Runtime <<= baseDirectory { base => base / "bots" }

initialCommands := "import net.mtgto.irc._"

ScctPlugin.instrumentSettings

testOptions in ScctTest += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")

org.scalastyle.sbt.ScalastylePlugin.Settings

publishTo := Some(Resolver.file("file", new File("maven/")))
