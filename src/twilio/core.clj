(ns twilio.core
  (:require [hiccup.core :refer [html]]
            [hiccup.page :refer [xml-declaration]]))

(defmacro twiml-response [& verbs]
  `(str
     (xml-declaration "utf-8")
     (html [:Response ~@verbs])))
