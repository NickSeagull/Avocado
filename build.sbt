name := "Avocado"

version := "0.0.0"

scalaVersion := "2.10.0"

libraryDependencies := {
  val sprayVersion = "1.3.3"
  val akkaVersion = "2.3.12"
  Seq(
    "io.spray"          %% "spray-can"       % sprayVersion,
    "io.spray"          %% "spray-routing"   % sprayVersion,
    "io.spray"          %% "spray-testkit"   % sprayVersion,
    "io.spray"          %% "spray-client"    % sprayVersion,
    "io.spray"          %% "spray-json"      % "1.3.2",
    "com.typesafe.akka" %% "akka-actor"      % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j"      % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit"    % akkaVersion % "test",
    "ch.qos.logback"     % "logback-classic" % "1.1.3",
    "org.scalatest"     %% "scalatest"       % "2.2.4" % "test"
  )
}

Revolver.settings
