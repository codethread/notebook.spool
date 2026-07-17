(ns ct.spools.notebook-test
  "Contract tests for capture!. This suite doubles as the previous-release
  compatibility alarm: it must pass against every later release of the
  same name."
  (:require [clojure.test :refer [deftest is]]
            [ct.spools.notebook :as notebook]))

(deftest capture-rejects-blank-text
  (is (thrown? clojure.lang.ExceptionInfo (notebook/capture! nil ""))))

(deftest capture-returns-entry
  (is (= "standup 9am" (:captured (notebook/capture! nil "standup 9am")))))
