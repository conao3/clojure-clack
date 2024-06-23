(ns clack.system
  (:require
   [clack.component.handler :as c.handler]
   [clack.component.server :as c.server]
   [clojure.tools.logging :as logging]
   [com.stuartsierra.component :as component]
   [unilog.config :as unilog]))

(defn- new-system []
  (component/system-map
   :handler (c.handler/map->Handler {})
   :server (component/using
            (c.server/map->Jetty9Server {:opts {:join? false :port 8000}})
            [:handler])))

(defonce logging-config {:level :debug
                         :console true
                         :overrides {"org.eclipse.jetty" :info}})

(defn start []
  (let [system (new-system)
        _ (unilog/start-logging! logging-config)
        _ (logging/info "system is ready to start")
        started-system (component/start system)
        _ (logging/info "system is started")]
    started-system))

(defn stop [system]
  (component/stop system))
