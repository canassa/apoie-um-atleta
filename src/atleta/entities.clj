(ns atleta.entities
  (:use [korma db core]
        [atleta.db :only [db]]))


(defentity athlete
  (entity-fields :name :age)
  (database db))
