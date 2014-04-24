name := "play-mvc"

version := "1.0-SNAPSHOT"

ebeanEnabled := false

libraryDependencies ++= Seq(
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  cache,
  "javax.inject" % "javax.inject" % "1",
  "org.springframework" % "spring-context" % "4.0.2.RELEASE",
  "org.springframework" % "spring-orm" % "4.0.2.RELEASE",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.2.Final",
  "org.hibernate" % "hibernate-c3p0" % "4.3.2.Final",
  "org.postgresql" % "postgresql" % "9.3-1101-jdbc4"
)


javacOptions ++= Seq("-source", "1.7", "-target", "1.7")


play.Project.playJavaSettings