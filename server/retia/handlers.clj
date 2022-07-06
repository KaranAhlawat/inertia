(ns retia.handlers
  (:require [inertia.middleware :as inertia]))

(defn home-handler
  [_]
  (inertia/render :home))

(defn users-handler
  [_]
  (inertia/render :users))

(defn settings-handler
  [_]
  (inertia/render :settings))