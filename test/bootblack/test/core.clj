(ns bootblack.test.core
  (:use [bootblack.core])
  (:use [clojure.test]))

(deftest error
         (let [r (error-item ["foobar"])
               exp "<span class=\"help-inline\">foobar</span>"]
           (is (= exp (str r)))))
