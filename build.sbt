ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

// https://mvnrepository.com/artifact/org.scala-lang.modules/scala-parallel-collections
libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4"

// https://mvnrepository.com/artifact/org.scala-lang/scala-xml
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.0"

lazy val root = (project in file("."))
  .settings(
    name := "learning_scala"
  )
