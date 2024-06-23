(ns clack.core
  (:gen-class)
  (:require
   [clojure.edn :as edn]
   [ring.adapter.jetty9 :as jetty]))

(def config-file-path (str
                       (System/getProperty "user.home")
                       "/.config/clack/config.edn"))

(defn load-config-edn []
  (edn/read-string
   (slurp config-file-path)))

(defn ring-handler [_req]
  {:status 200
   :body "Hello, Clojure API"})

(defn -main [& _args]
  (jetty/run-jetty ring-handler {:port 8000}))
