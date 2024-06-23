(ns clack.component.handler
  (:require
   [com.stuartsierra.component :as component]))

(defn- ring-handler [_req]
  {:status 200
   :body "Hello, Clojure API mod!!!!"})

(defrecord Handler [handler]
  component/Lifecycle
  (start [this]
    (assoc this :handler ring-handler))
  (stop [this]
    (assoc this :handler nil)))