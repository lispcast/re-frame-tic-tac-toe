(ns tic-tac-toe.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :name
 (fn [db]
   (reaction (:name @db))))

(re-frame/register-sub
  :db
  (fn [db]
    db))

(re-frame/register-sub
  :cell
  (fn [db [_ x y]]
    (reaction (get-in @db [:board [x y]]))))

(re-frame/register-sub
  :turn
  (fn [db _]
    (reaction (:turn @db))))

(re-frame/register-sub
  :winner
  (fn [db _]
    (reaction (:winner @db))))
