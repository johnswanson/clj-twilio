(defproject clj-twilio "0.2.1"
  :description "Clojure Twilio API"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [hiccup "1.0.3"]]
  :dev-dependencies [[lein-clojars "0.5.0"]
                     [swank-clojure "1.2.1"]]
  :aot [twilio.core
        twilio.twiml.core
        twilio.twiml.sms
        twilio.twiml.voice]
  :jar-name "clj-twilio.jar")
