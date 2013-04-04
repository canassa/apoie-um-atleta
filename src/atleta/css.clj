(ns atleta.css
  (:require (gaka [core :as gaka])))


(defn prepare [css]
  (clojure.walk/postwalk #(cond (ratio? %) (str (float (* 100 %)) "%")
                                (number? %) (str % "px")
                                :else %)
                         css))

(def half-screen (list :float "left" :width "50%"))
(def header-shadow (list :text-shadow "-1px 1px 0px black"))


(defn url [& args]
  (str "url(/" (apply str args) ")"))

(def url-img (partial url "img/"))
(def url-font (partial url "font/"))

(def orange "#ff7e00")
(def green "#77b110")


(defn font-face [family file weight] [
  "@font-face"
    :font-family family
    :src (url-font file ".eot")
    :src (clojure.string/join ", " [
           (str (url-font file ".eot?#iefix") " format('embedded-opentype')")
           (str (url-font file ".otf") " format('opentype')")
           (str (url-font file ".woff") " format('woff')")
           (str (url-font file ".svg#" file) " format('svg')")])
    :font-weight weight
    :font-style "normal"
    ])


(def _rule [
  (font-face "caturrita" "caturrita-medium" "bold")
  (font-face "caturrita" "caturrita-regular" "normal")
           
  [:body
    :font-family "\"caturrita\", serif"
    :-webkit-font-feature-settings "\"liga\", \"dlig\""
    :-moz-font-feature-settings "\"liga\", \"dlig\""
    :font-feature-settings "\"liga\", \"dlig\""]
           
  ["h1, h2, h3"
    :font-weight "bold"]
           
  [:h2.orange
    :color orange
    header-shadow]

  [:h2.green
    :color green
    header-shadow]           
           
  [:h2.green
    :color green]

  ["body > header"
    :position "relative"
    :height 270
    :background (url-img "bg-header.png")
    [:h1
      :color "white"
      :text-align "center"
      :margin 0]
    [:.menu
      :position "absolute"
      :left 1/2
      :bottom 0
     
      :width 600
      :height 50
     
      :margin "0 auto"
      :background (url-img "bg-menu.png")
      [:a
        :color "white"
        :text-decoration "none"]
      [:li
        :float "left"
        :width 1/4]]]
           
  [:#main 
    :width 965
    :margin "0 auto"
    [:.group
      :overflow "auto"]]
           
  [:#atletas-destaque
    half-screen]
           
  [:#ranking
    half-screen]
           
  [:footer
    :height 35
    :background (url-img "bg-header.png")]
  ])


(def rule (prepare _rule))


(defn -main []
  (gaka/css rule))
