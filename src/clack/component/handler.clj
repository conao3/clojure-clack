(ns clack.component.handler
  (:require
   [clack.handler.api.greeting]
   [clack.handler.health]
   [clack.router :as c.router]
   [com.stuartsierra.component :as component]
   [reitit.ring :as ring]
   [ring.logger :as m.logger]))

(defn- build-handler []
  (ring/ring-handler
   c.router/router
   nil
   {:middleware [m.logger/wrap-with-logger]}))

(defrecord Handler [handler]
  component/Lifecycle
  (start [this]
    (assoc this :handler (build-handler)))
  (stop [this]
    (assoc this :handler nil)))
