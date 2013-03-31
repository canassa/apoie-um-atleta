(ns atleta.views
  (:use [hiccup core page]
        [atleta css entities]
        [korma db core])
  (:require (gaka [core :as gaka])))


(defn athletes []
  (map (fn [{name :name, age :age}]
         [:div
           [:h2 name]
           [:p age]]) (select athlete)))


(defn index-page []
  (html5
    [:head
      [:title "apoie um atleta"]
      (include-css "/css/normalize.css"
                   "/css/style.css")
      [:style (map gaka/css rule)]]
    [:body
      [:header
        [:h1 "apoie um atleta"]
        [:nav.menu
          [:ul
            [:li [:a {:href "/"} "Home"]]
            [:li [:a {:href "/"} "Atletas"]]
            [:li [:a {:href "/"} "Como funciona"]]
            [:li [:a {:href "/"} "Quem somos"]]]]]
      [:section#main
         [:div.group
           [:article#atletas-destaque
             [:h2 "Atletas em destaque"]
             (athletes)]
           [:article#ranking
              [:h2 "Ranking"]]]]]))
  