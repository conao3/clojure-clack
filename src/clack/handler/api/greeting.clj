(ns clack.handler.api.greeting
  (:require
   [ring.util.http-response :as res]))

(defn hello [_]
  (res/ok "Hello world"))

(defn goodbye [_]
  (res/ok "Goodbye"))
