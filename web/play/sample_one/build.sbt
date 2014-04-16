name := "sample_one"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")


play.Project.playJavaSettings