(ns utils
  (:import (flask Flask)))

(def app nil)

(defmacro defroute
  "Defines a new route"
  [name path args body]
  `(let [f# (fn ~args ~body)]
     (.__setattr__ f# "func_name" (str (quote ~name)))
     ((.route (quote ~app) ~path) f#)))

(defn create-global
  "Create a global flask app"
  [name]
  (def app (Flask. name)))

(defn start-server
  "Starts the server"
  []
  (.run app))