(ns atleta.handler
  (:use compojure.core
        atleta.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World!!!")
  (GET "/1" [] (index-page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

