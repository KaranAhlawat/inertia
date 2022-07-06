(ns retia.system
  (:require
    [integrant.core :as ig]
    [ring.adapter.jetty :refer [run-jetty]]
    [retia.server :refer [app]]))

(def config {:adapter/jetty {:port 3000
                             :join? false}})

(defmethod ig/init-key :adapter/jetty
  [_ opts]
  (run-jetty #'app opts))

(defmethod ig/halt-key! :adapter/jetty
  [_ server]
  (.stop server))

(defn -main
  []
  (ig/init config))
