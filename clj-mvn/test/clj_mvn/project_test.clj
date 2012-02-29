(ns clj-mvn.project-test
  (:require
   [clojure.java.io :as io])
  (:use
   clojure.test
   clj-mvn.project))

(deftest a-test
  (testing "basic project reading"
    (is (= {:group "org.cloudhoist",
            :name "pallet-pom",
            :version "0.7.2-SNAPSHOT",
            :description "Pallet - parent pom",
            :source-paths ["src"],
            :test-paths ["test"]}
           (read-pom (io/resource "pom.xml"))))))
