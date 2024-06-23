(ns clack.component.handler
  (:require
   [clack.handler.api.greeting]
   [clack.handler.health]
   [clack.router :as c.router]
   [com.stuartsierra.component :as component]
   [reitit.ring :as ring]))

(defn- build-handler []
  (ring/ring-handler c.router/router))

(defrecord Handler [handler]
  component/Lifecycle
  (start [this]
    (assoc this :handler (build-handler)))
  (stop [this]
    (assoc this :handler nil)))
