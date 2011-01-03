(ns cp.core
  (:gen-class))
(use '[clojure.java.io :only (reader writer copy as-file)])

(defn copy-file [src-file dst-file]
  (with-open [src (reader src-file) dst (writer dst-file)]
    (copy src dst)))

(defn -main [& args]
  (let [src (first args)
        dst (second args)]
    (if (.isFile (as-file src))
      (copy-file src dst)
      (println (str src " is directory")))))
