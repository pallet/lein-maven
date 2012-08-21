(ns leiningen.mvn
  (:require
   [classlojure.core :as cl]
   [clojure.java.io :as io]
   [leiningen.core.classpath :as classpath])
  (:use
   [clojure.pprint :only [pprint]]
   [leiningen.core.eval :only [eval-in-project eval-in]]))

(defmethod eval-in :myclassloader [project form]
  (let [classpath (map io/file (classpath/get-classpath project))
        classloader (cl/classlojure classpath)]
    (try
      (cl/eval-in classloader form)
      (catch Exception e
        (.printStackTrace e)))))

(defn- read-pom [file]
  (eval-in-project
   {:dependencies [['clj-mvn "0.1.0"]]
    :eval-in :myclassloader}
   `(do
      (require 'clj-mvn.project)
      (clj-mvn.project/read-pom ~file))))

(defn ^{:no-project-needed true}
  mvn
  "Read a maven pom"
  [project & args]
  (let [p (read-pom "pom.xml")
        p (list 'defproject (symbol (:group p) (:name p)) (:version p)
                :description (:description p)
                :source-paths (vec (:source-paths p))
                :test-paths (vec (:test-paths p)))]
    (pprint p)
    (flush)))

(defn- add-checkout
  [project pom]
  (let [p (read-pom (.getPath pom))]
    (-> project
        (update-in [:source-paths] concat
                   (map #(str (.getParent pom) "/" %) (:source-paths p))))))

(defn- add-checkout-paths
  [project checkouts]
  (reduce
   (fn [project f]
     (let [pom (and (.isDirectory f) (io/file f "pom.xml"))]
       (if (.exists pom)
         (add-checkout project pom)
         project)))
   project
   (.listFiles checkouts)))

(defn maven-checkouts
  [project]
  (let [checkouts (io/file (:root project) "checkouts")]
    (if (.isDirectory checkouts)
      (add-checkout-paths project checkouts)
      project)))
