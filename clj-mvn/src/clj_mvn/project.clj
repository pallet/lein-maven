(ns clj-mvn.project
  (:require
   [clojure.java.io :as io])
  (:use
   [maven-embedder.manager :only [project]]))

(defn read-pom
  [pom-path]
  (let [file (io/file pom-path)
        filename (.getAbsolutePath file)
        project (project file)
        base (subs filename 0 (- (count filename) 7))
        n (count base)]
    {:name (.getArtifactId project)
     :group (.getGroupId project)
     :version (.getVersion project)
     :description (.getDescription project)
     :source-paths (map #(subs % n (count %))
                        (.getCompileSourceRoots project))
     :test-paths (map #(subs % n (count %))
                      (.getTestCompileSourceRoots project))
     ;; :resource-paths (vec (.getResources project))
     ;; :test-resource-paths (vec (.getTestResources project))
     }))
