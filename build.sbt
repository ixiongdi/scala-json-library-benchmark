resolvers ++= Seq(
  "OS China" at "http://maven.oschina.net/content/groups/public/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "twitter-repo" at "http://maven.twttr.com",
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Akka" at "http://repo.akka.io/releases/"
)


libraryDependencies ++= Seq(
  "com.google.caliper" % "caliper" % "1.0-beta-1",
  "org.json4s" %% "json4s-native" % "3.2.5",
  "org.json4s" %% "json4s-jackson" % "3.2.5",
  "net.minidev" % "json-smart" % "2.0-RC3",
  "javax" % "javaee-api" % "7.0",
  "org.glassfish" % "simple-glassfish-api" % "3.1.1"
)
