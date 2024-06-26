(ns clack.component.server
  (:require
   [com.stuartsierra.component :as component]
   [ring.adapter.jetty9 :as jetty]))

(defrecord Jetty9Server [handler opts server]
  component/Lifecycle
  (start [this]
    (if server
      this
      (assoc this :server (jetty/run-jetty (:handler handler) opts))))
  (stop [this]
    (when server
      (jetty/stop-server server))
    (assoc this :server nil)))
