(ns clack.core-test
  (:require
   [clack.core :as sut]
   [clojure.test :as t]))

(t/deftest load-config-test
  (t/testing "load-config"
    (t/is (map? (sut/load-config-edn)))))
