(defproject clj-mvn "0.1.0-SNAPSHOT"
  :description "Maven pom reader for clojure"
  :dependencies [[org.cloudhoist/maven-embedder "0.1.0"]
                 [org.clojure/clojure "1.3.0"]]
  :profiles {:dev {:resource-paths ["test-resources"]}}
  :repositories
  {"sonatype-snapshots" "https://oss.sonatype.org/content/repositories/snapshots"
   "sonatype" "https://oss.sonatype.org/content/repositories/releases/"})
