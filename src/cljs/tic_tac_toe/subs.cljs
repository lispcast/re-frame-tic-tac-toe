(ns tic-tac-toe.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
  :db
  (fn [db]
    db))

(re-frame/reg-sub
  :cell
  (fn [db [_ x y]]
    (get-in db [:board [x y]])))

(re-frame/reg-sub
  :turn
  (fn [db _]
    (:turn db)))

(re-frame/reg-sub
  :winner
  (fn [db _]
    (:winner db)))
