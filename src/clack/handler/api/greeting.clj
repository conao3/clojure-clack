(ns clack.handler.api.greeting
  (:require
   [clack.handler :as h]
   [clack.router :as r]
   [ring.util.http-response :as res]))

(defmethod h/handler [::r/hello :get] [_]
  (res/ok {:greeting "Hello cljapi!"}))

(defmethod h/handler [::r/goodbye :get] [_]
  (res/ok "Goodbye"))
