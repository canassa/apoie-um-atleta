(ns atleta.views
  (:use [hiccup core page]
        [atleta entities]
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
      [:style (map gaka/css atleta.css/rule)]]
    [:body
      [:header
        [:h1 "apoie um atleta"]
        [:nav.menu
          [:ul
            [:li [:a {:href "/"} "home"]]
            [:li [:a {:href "/"} "atletas"]]
            [:li [:a {:href "/"} "como funciona"]]
            [:li [:a {:href "/"} "quem somos"]]]]]
      [:section#main
         [:div.group
           [:article#atletas-destaque
             [:h2.orange "Atletas em destaque"]
             (athletes)]
           [:article#ranking
              [:h2.green "Ranking"]]]]
      [:footer]]))
  