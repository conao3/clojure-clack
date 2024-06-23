(ns clack.handler.health
  (:require
   [clack.handler :as h]
   [clack.router :as r]
   [ring.util.http-response :as res]))

(defmethod h/handler [::r/health :get] [_]
  (res/ok "Application is running"))
