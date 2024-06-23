(ns clack.core
  (:gen-class)
  (:require
   [clack.system :as c.system]
   [clojure.edn :as edn]))

(def config-file-path (str
                       (System/getProperty "user.home")
                       "/.config/clack/config.edn"))

(defn load-config-edn []
  (edn/read-string
   (slurp config-file-path)))

(defn -main [& _args]
  (c.system/start))
