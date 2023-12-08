(ns htds.ui.app
  (:require [react :as react]
            ["react-dom/client" :as rdom]
            [reagent.core :as r]))

(defn my-component []
  [:div "Hello World!"])

(defn ^:dev/after-load render []
  (let [el (.getElementById js/document "root")
        root (.createRoot rdom el)]
    (.render root (r/as-element [my-component]))))

(defn ^:export init [] (render))
