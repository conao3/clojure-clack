(ns clack.handler.router
  (:require
   [clack.handler.api.greeting :as c.h.api.greeting]
   [clack.handler.health :as c.h.health]
   [reitit.ring :as ring]))

(def router
  (ring/router
   [["/health" c.h.health/health]
    ["/api"
     ["/hello" c.h.api.greeting/hello]
     ["/goodbye" c.h.api.greeting/goodbye]]]))
