(ns atleta.css
  (:require (gaka [core :as gaka])))


(def half-screen (list :float "left" :width "50%"))


(defn url [& args]
  (str "url(/" (apply str args) ")"))

(def url-img (partial url "img/"))
(def url-font (partial url "font/"))


(defn font-face [family file weight] [
  "@font-face"
    :font-family family
    :src (url-font file ".eot")
    :src (clojure.string/join ", " [
           (str (url-font file ".eot?#iefix") " format('embedded-opentype')")
           (str (url-font file ".woff") " format('woff')")
           (str (url-font file ".ttf") " format('truetype')")
           (str (url-font file ".svg#" file) " format('svg')")])
    :font-weight weight
    :font-style "normal"
    ])


(def rule [
  (font-face "caturrita" "caturrita-medium" "bold")
  (font-face "caturrita" "caturrita-regular" "normal")
           
  [:body
    :font-family "\"caturrita\", serif"]
           
  ["h1, h2, h3"
    :font-weight "bold"]

  ["body > header"
    :height "270px"
    :background (url-img "bg-header.png")
    [:h1
      :color "white"
      :text-align "center"
      :margin 0]
    [:.menu
      :width "600px"
      :height "50px"
      :margin "0 auto"
      :background (url-img "bg-menu.png")
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
    :background (url-img "bg-header.png")]
  ])

(defn -main []
  (gaka/css rule))
