(ns atleta.db
  (:use [korma db core])
  (:require [clojure.java.jdbc :as jdbc]))


(defdb db (sqlite3 {:db "db.sqlite"}))


(def db-spec {:classname "org.sqlite.JDBC"
              :subprotocol "sqlite"
              :subname "db.sqlite"})


(defn setup []
  (jdbc/with-connection db-spec
    (jdbc/create-table :athlete
                       [:id "integer primary key"]
                       [:name "varchar"]
                       [:age "varchar"])))


;(select athlete)


;(insert athlete
;  (values {:name "mary" :age "20 anos"}))