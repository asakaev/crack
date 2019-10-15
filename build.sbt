ThisBuild / scalaVersion := "2.13.1"

lazy val crack = (project in file("."))
  .settings(
    name := "crack",
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % "test"
  )
