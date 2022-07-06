(ns user
  (:require [integrant.repl :as ig]
            [retia.system :as system]))

(ig/set-prep! (fn [] system/config))

(comment
  (ig/go)
  (ig/halt)
  (ig/reset)
  (ig/reset-all)
  (+ 1 2)
  ,)



