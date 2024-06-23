(ns clack.handler.health
  (:require
   [ring.util.http-response :as res]))

(defn health [_]
  (res/ok "Application is running"))
