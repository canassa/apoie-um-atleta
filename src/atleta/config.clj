(ns atleta.config)

(def production?
  (= "production" (get (System/getenv) "APP_ENV")))

(def development?
  (not production?))
