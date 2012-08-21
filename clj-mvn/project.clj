(defproject clj-mvn "0.1.0"
  :description "Maven pom reader for clojure"
  :url "https://github.com/pallet/lein-maven"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.cloudhoist/maven-embedder "0.1.1"]
                 [org.clojure/clojure "1.3.0"]]
  :profiles {:dev {:resource-paths ["test-resources"]}}
  :repositories
  {"sonatype" "https://oss.sonatype.org/content/repositories/releases/"}
  :scm {:url "git@github.com:pallet/lein-maven.git"}
  :pom-addition [:developers [:developer
                              [:name "Hugo Duncan"]
                              [:url "http://hugoduncan.org"]
                              [:email "hugo at hugoduncan.org"]
                              [:timezone "-5"]]])
