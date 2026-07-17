(ns ct.spools.notebook2-test
  "Contract tests for the second-generation root — the compat-alarm
  baseline for notebook2's own future releases."
  (:require [clojure.test :refer [deftest is]]
            [ct.spools.notebook2 :as notebook2]))

(deftest capture-requires-explicit-date
  (is (thrown? clojure.lang.ExceptionInfo (notebook2/capture! nil "x" nil))))

(deftest capture-carries-date
  (is (= "2026-07-17" (:on (notebook2/capture! nil "x" "2026-07-17")))))
