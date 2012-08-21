(defproject lein-maven "0.1.0"
  :description "Maven pom reader"
  :url "https://github.com/pallet/lein-maven"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[leiningen-core "2.0.0-SNAPSHOT"]
                                  [org.clojure/clojure "1.3.0"]]}}
  :scm {:url "git@github.com:pallet/lein-maven.git"}
  :pom-addition [:developers [:developer
                              [:name "Hugo Duncan"]
                              [:url "http://hugoduncan.org"]
                              [:email "hugo at hugoduncan.org"]
                              [:timezone "-5"]]])
