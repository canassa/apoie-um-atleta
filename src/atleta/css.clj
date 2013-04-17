(ns atleta.css
  (:require (clojure walk)
            (gaka [core :as gaka])))


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

  [:*
    :box-sizing "border-box"]
            
  [:body
    :font-family "\"caturrita\", serif"
    :-webkit-font-feature-settings "\"liga\", \"dlig\""
    :-moz-font-feature-settings "\"liga\", \"dlig\""
    :font-feature-settings "\"liga\", \"dlig\""]
           
  ["h1, h2, h3"
    :font-weight "bold"]
           
  [:h2.orange
    :color orange
    :margin-left 20
    :font-size 31
    header-shadow]
            
  [:h2.orange:before
    :content "\"\""
    :float "left"
   
    :width 15
    :height 15
      
    :margin-top 4
    :margin-left -20
    :background (url-img "bullet-orange.png")]

  [:h2.green
    :color green
    :margin-left 20
    :font-size 31
    header-shadow]
           
  [:h2.green
    :color green]

  ["body > header"
    :position "relative"
    :height 270
    :overflow "auto"
    :background (url-img "bg-header.png")
    [:.logo
      :display "block"
      :margin "15px auto"]
    [:h1
      :color "white"
      :text-align "center"
      :margin 0
      :margin-top 22
      :font-size 31]
    [:.menu
      :position "absolute"
      :left 1/2
      :bottom 0
     
      :width 600
      :height 50
     
      :margin 0
      :margin-left -300
      :font-size 16
      :background (url-img "bg-menu.png")
      [:a
        :display "block"
       
        :width "100%"
        :height "100%"
       
        :color "white"
        :text-decoration "none"
        :transition "text-shadow 1s linear, color 500ms linear"
        :text-shadow "0px 0px 25px rgba(130, 181, 235, 0)"
        :text-align "center"
        :line-height 48]
      ["a:hover"
        :color "#82b5eb"
        :text-shadow "0px 0px 25px rgba(130, 181, 235, 1)"]
      [:ul
        :width "100%"
        :height "100%"
        :margin 0
        :padding 0]
      [:li
        :float "left"
        :width 1/4
        :height "100%"
        :border-top "3px solid white"
        :transition "border-color 500ms linear"]
      [:li:hover
        :border-color "#237cdc"]]]
           
  [:#main 
    :width 965
    :margin "0 auto"
    [:.group
      :overflow "auto"]]
           
  [:#atletas-destaque
    [:.name
      :margin "6px 10px 0 0"
      :float "left"
      :font-size 24]
    half-screen]
           
  [:#ranking
    half-screen]
           
  [:footer
    :height 35
    :background (url-img "bg-header.png")]])


(def rule (prepare _rule))
