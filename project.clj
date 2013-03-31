(defproject atleta "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]
                 [gaka "0.3.0"]
                 [org.xerial/sqlite-jdbc "3.7.2"]
                 [korma "0.3.0-RC4"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler atleta.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
