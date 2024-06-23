(ns clack.system
  (:require
   [clack.component.handler :as c.handler]
   [clack.component.server :as c.server]
   [com.stuartsierra.component :as component]))

(defn- new-system []
  (component/system-map
   :handler (c.handler/->Handler {})
   :server (component/using
            (c.server/map->Jetty9Server {:opts {:join? false :port 8000}})
            [:handler])))

(defn start []
  (component/start (new-system)))

(defn stop [system]
  (component/stop system))

