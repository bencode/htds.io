(ns htds.ui.app
  (:require [react :as react]
            ["react-dom/client" :as rdom]
            [reagent.core :as r]))

(defn header []
  [:h1 {:style {:color "blue"}}
   [:div "Hello World!"]])

(defn counter [n]
  (let [count (r/atom n)]
    (fn []
      [:<>
       [:div @count]
       [:button {:on-click #(swap! count inc)} "Click Me"]])))

(defn app []
  [:<>
   [header]
   [counter 200]])

(defn ^:dev/after-load render []
  (let [el (.getElementById js/document "root")
        root (.createRoot rdom el)]
    (.render root (r/as-element [app]))))

(defn ^:export init [] (render))
