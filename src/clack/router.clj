(ns clack.router
  (:require
   [clack.handler :as c.handler]
   [reitit.ring :as ring]))

(def router
  (ring/router
   [["/health" {:name ::health :handler c.handler/handler}]
    ["/api"
     ["/hello" {:name ::hello :handler c.handler/handler}]
     ["/goodbye" {:name ::goodbye :handler c.handler/handler}]]]))
