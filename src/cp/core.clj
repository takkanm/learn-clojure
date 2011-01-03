(ns cp.core
  (:gen-class))
(use '[clojure.contrib.duck-streams :only (reader writer copy)])

(defn copy-file [src-file dst-file]
  (with-open [src (reader src-file) dst (writer dst-file)]
    (copy src dst)))

(defn -main [& args]
  (copy-file (first args) (second args)))
