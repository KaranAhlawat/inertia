(ns retia.server
  (:require [reitit.ring :as ring]
            [reitit.ring.middleware.parameters :refer [parameters-middleware]]
            [reitit.ring.middleware.exception :refer [exception-middleware]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [inertia.middleware :as inertia]
            [selmer.parser :as html]
            [retia.handlers :as h]))

(def asset-version "1")

(defn template [data-page]
  (html/render-file "index.html" {:page data-page}))

(def app
  (ring/ring-handler
   (ring/router
    [["/" {:get {:handler #'h/home-handler}}]
     ["/users" {:get {:handler #'h/users-handler}}]
     ["/settings" {:get {:handler #'h/settings-handler}}]
     ["/logout" {:post (fn [_]
                         (println "Logged user out")
                         {:status 200})}]]
    {:data {:middleware [parameters-middleware
                         wrap-keyword-params
                         exception-middleware
                         [inertia/wrap-inertia template asset-version]]}})
   (ring/routes
    (ring/create-resource-handler
     {:path "/"
      ;; This is relative to the resource folder.
      :root "."})
    (ring/redirect-trailing-slash-handler)
    (ring/create-default-handler
     {:not-found (constantly {:status 404
                              :body "Route not found"})}))))

(comment
  (app {:request-method :get, :uri "/"})
  (app {:request-method :get, :uri "/users"})
  (app {:request-method :post :uri "/logout"})
  ,)
