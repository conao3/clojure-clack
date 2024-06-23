(ns clack.core
  (:gen-class)
  (:require
   [clojure.edn :as edn]))

(def config-file-path (str
                       (System/getProperty "user.home")
                       "/.config/clack/config.edn"))

(defn load-config-edn []
  (edn/read-string
   (slurp config-file-path)))

(defn greet
  "Callable entry point to the application."
  [data]
  (println (str "Hello, " (or (:name data) "World") "!")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))
