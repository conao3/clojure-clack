(ns user
  (:require
   [clack.system :as c.system]))

(defonce system (atom nil))

(defn start []
  (reset! system (c.system/start)))

(defn stop []
  (when @system
    (reset! system (c.system/stop @system))))

(defn go []
  (stop)
  (start))
