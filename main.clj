(ns main
  (:require [utils :as u]))

(u/create-global __name__)

(u/defroute hello "/"
  []
  "Hello World")

(u/before-request print-before
                  (println "Before request"))

(u/after-request print-after [resp]
                 (do
                   (println (str "After request: " resp))
                   resp))

(u/start-server "127.0.0.1" 5000 true)