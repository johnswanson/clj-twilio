(ns twilio.test.core
  (:use [twilio.core] :reload)
  (:use [clojure.test]
        [twilio.twiml.voice :only [say play gather]]))

(deftest test-twilio-voice-response
  (is (= (twiml-response (say "Message"))
         "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<Response><Say>Message</Say></Response>"))
  (is (= (twiml-response (say "Message")
                          (play "message.mp3"))
         "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<Response><Say>Message</Say><Play>message.mp3</Play></Response>"))
  (is (= (twiml-response (gather {:action "/process_gather.php" :method "GET"}
                                  (say "Please enter your account number, followed by the pound sign")))
         "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<Response><Gather action=\"/process_gather.php\" method=\"GET\"><Say>Please enter your account number, followed by the pound sign</Say></Gather></Response>"))
  (is (= (twiml-response (gather {:action "/process_gather.php" :method "GET"}
                                  (say "Please enter your account number, followed by the pound sign"))
                          (say "We didn't receive any input. Goodbye!"))
         "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<Response><Gather action=\"/process_gather.php\" method=\"GET\"><Say>Please enter your account number, followed by the pound sign</Say></Gather><Say>We didn't receive any input. Goodbye!</Say></Response>")))
