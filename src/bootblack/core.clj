(ns bootblack.core
  (:require [noir.validation :as vali]
            [hiccup.form-helpers :as form])
  (:use noir.core
        hiccup.core))

(defpartial error-item [[first-error]]
            [:span.help-inline first-error])

(defpartial input-field [inputgen nam label value]
            (let [err? (vali/errors? nam)
                  formname (name nam)
                  divclass (if err? "clearfix error" "clearfix")
                  inputclass (if err? "input error" "input")
                  elemclass (if err? "error" "")]
              [:div {:class divclass} 
               [:label {:for formname} label]
               [:div {:class inputclass}
                (inputgen {:class elemclass} formname value)
                (vali/on-error nam error-item)]]))

(defpartial text-field [nam label value]
            (input-field form/text-field nam label value))

(defpartial password-field [nam label value]
            (input-field form/password-field nam label value))

(defpartial form-to [legend submittxt url method & contents]
            [:form.form-stacked {:method method :action url}
             [:fieldset
              [:legend legend]
              contents]
             [:fieldset
              [:div.actions
               (form/submit-button {:class "btn primary"} submittxt)]]])
