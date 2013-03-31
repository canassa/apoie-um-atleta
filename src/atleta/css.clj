(ns atleta.css
  (:require (gaka [core :as gaka])))

(def half-screen (list :float "left" :width "50%"))

(defn url [img] (str "url(/img/" img ")"))

(def rule [
           
  ["body > header"
    :height "270px"
    :background (url "bg-header.png")
    [:h1
      :color "white"
      :text-align "center"
      :margin 0]
    [:.menu
      :width "600px"
      :height "50px"
      :margin "0 auto"
      :background (url "bg-menu.png")
      [:a
        :color "white"
        :text-decoration "none"]
      [:li
        :float "left"
        :width "25%"]]]
           
  [:#main 
    :width "965px"
    :margin "0 auto"
    [:.group
      :overflow "auto"]]
           
  [:#atletas-destaque
    half-screen]
           
  [:#ranking
    half-screen]
           
  [:footer
    :height "35px"
    :background (url "bg-header.png")]
  ])

(defn -main []
  (gaka/css rule))
