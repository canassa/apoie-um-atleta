(ns atleta.css
  (:require (gaka [core :as gaka])))

(def half-screen (list :float "left" :width "50%"))

(def rule [
  ["body > header"
    [:h1
      :text-align "center"]
    [:.menu
      :width "600px"
      :margin "0 auto"
      [:li
        :float "left"]]]
  [:#main 
    :width "965px"
    :margin "0 auto"]
  [:#atletas-destaque
    half-screen]
  [:#ranking
    half-screen]
  ])

(defn -main []
  (gaka/css rule))
