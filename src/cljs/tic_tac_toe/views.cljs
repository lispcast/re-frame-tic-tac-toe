(ns tic-tac-toe.views
  (:require [re-frame.core :as re-frame]))

(defn cell [x y]
  (let [c (re-frame/subscribe [:cell x y])
        winner (re-frame/subscribe [:winner])]
    (fn []
      (case @c
        :x [:span "X"]
        :o [:span "O"]
        (if @winner
          [:span]
          [:button {:on-click #(re-frame/dispatch [:move x y])}
           " "])))))

(defn grid []
  [:table
   (for [y (range 3)]
     [:tr
      (for [x (range 3)]
        [:td {:style {:width 30
                      :height 30
                      :text-align :center}}
         [cell x y]])])])

(defn main-panel []
  (let [db (re-frame/subscribe [:db])
        turn (re-frame/subscribe [:turn])
        winner (re-frame/subscribe [:winner])]
    (fn []
      [:div
       (if @winner
         [:div
          (name @winner) " is the winner."]
         [:div
          (name @turn) " to play."])
       [grid]
       [:button {:on-click #(re-frame/dispatch [:initialize-db])}
        "RESET"]
       [:div
        (pr-str @db)]])))
