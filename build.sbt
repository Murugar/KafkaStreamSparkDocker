name := "KafkaStreamSparkDocker"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.1.0" % "provided"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.1.0" % "provided"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.1.0" % "provided"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-8_2.11" % "2.1.0"


mainClass in assembly := some("com.iqmsoft.spark.streams.DirectKafkaRDF")
assemblyJarName := "streaming.jar"

assemblyMergeStrategy in assembly := {
  case PathList("org","aopalliance", xs @ _*) => MergeStrategy.last
  case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)