(ns clack.router
  (:require
   [clack.handler :as c.handler]
   [camel-snake-kebab.core :as csk]
   [reitit.ring :as ring]
   [clojure.core.memoize :as memo]
   [muuntaja.core :as muu]
   [muuntaja.middleware :as muu.middleware]))

(def ^:private memoized->camelCaseString
  (memo/lru csk/->camelCaseString {} :lru/threshold 1024))

(def ^:private muuntaja-config
  (-> muu/default-options
      (assoc-in [:formats "appliction/json" :encoder-opts]
                {:encode-key-fn memoized->camelCaseString})
      (update :formats #(select-keys % ["application/json"]))
      muu/create))

(def router
  (ring/router
   [["/health" {:name ::health :handler c.handler/handler}]
    ["/api" {:middleware [[muu.middleware/wrap-format muuntaja-config]
                          muu.middleware/wrap-params]}
     ["/hello" {:name ::hello :handler c.handler/handler}]
     ["/goodbye" {:name ::goodbye :handler c.handler/handler}]]]))
