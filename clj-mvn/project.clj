(defproject clj-mvn "0.1.0-SNAPSHOT"
  :description "Maven pom reader for clojure"
  :dependencies [[com.palletops/maven-embedder "0.1.0-SNAPSHOT"]
                 [org.clojure/clojure "1.3.0"]]
  :profiles {:dev {:resource-paths ["test-resources"]}})
