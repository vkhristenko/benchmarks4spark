// common setup
name := "benchmarks4spark"
organization := "ch.cern"
version := "0.0.0"
scalaVersion := "2.11.12"

// 4 spark
spIgnoreProvided := true
sparkVersion := "2.2.1"
sparkComponents := Seq("sql")

resolvers += Resolver.mavenLocal

libraryDependencies += "org.diana-hep" % "spark-root_2.11" % "0.1.16"
