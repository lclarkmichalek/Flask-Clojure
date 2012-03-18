(ns main
  (:require [utils :as u]))

(u/create-global __name__)

(u/defroute hello "/hello"
  []
  "Hello World")

(u/start-server)