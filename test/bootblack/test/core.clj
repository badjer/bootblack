(ns bootblack.test.core
  (:use [bootblack.core])
  (:use [noir.util.test])
  (:use [clojure.test]))

(deftest error
         (let [r (error-item ["foobar"])
               exp "<span class=\"help-inline\">foobar</span>"]
           (is (= exp (str r)))))

(deftest text
         (with-noir
           (let [r (text-field :name "name" "badjer")
                 exp "<div class=\"clearfix\"><label for=\"name\">name</label><div class=\"input\"><input class=\"\" id=\"name\" name=\"name\" type=\"text\" value=\"badjer\" /></div></div>"]
             (is (= exp (str r))))))

(deftest password
         (with-noir
           (let [r (password-field :name "name" "badjer")
                 exp "<div class=\"clearfix\"><label for=\"name\">name</label><div class=\"input\"><input class=\"\" id=\"name\" name=\"name\" type=\"password\" value=\"badjer\" /></div></div>"]
             (is (= exp (str r))))))

(deftest form
         (with-noir
           (let [field (text-field :name "name" "badjer")
                 r (form-to "legend" "submittxt" "/dostuff" "POST" field)
                 exp "<form action=\"/dostuff\" method=\"POST\"><fieldset><legend>legend</legend><div class=\"clearfix\"><label for=\"name\">name</label><div class=\"input\"><input class=\"\" id=\"name\" name=\"name\" type=\"text\" value=\"badjer\" /></div></div></fieldset><fieldset><div class=\"actions\"><input class=\"btn primary\" type=\"submit\" value=\"submittxt\" /></div></fieldset></form>"]
             (is (= exp (str r))))))
