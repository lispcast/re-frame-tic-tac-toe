(ns tic-tac-toe.handlers
    (:require [re-frame.core :as re-frame]
              [tic-tac-toe.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(defn rotate [turn]
  (if (= :x turn)
    :o
    :x))

(defn row [board y]
  (for [x (range 3)]
    (get board [x y])))

(defn col [board x]
  (for [y (range 3)]
    (get board [x y])))

(defn diag [board transform]
  (for [[x y] (map vector
                (transform (range 3))
                (range 3))]
    (get board [x y])))

(defn winner [board]
  (or
    (first
      (for [y (range 3)
            :let [row (row board y)]
            :when (apply = row)
            :when (keyword? (first row))]
        (first row)))
    (first
      (for [x (range 3)
            :let [col (col board x)]
            :when (apply = col)
            :when (keyword? (first col))]
        (first col)))
    (let [diag (diag board identity)]
      (when (apply = diag)
        (when (keyword? (first diag))
          (first diag))))
    (let [diag (diag board reverse)]
      (when (apply = diag)
        (when (keyword? (first diag))
          (first diag))))))

(re-frame/register-handler
  :move
  (fn [db [_ x y]]
    (let [turn (:turn db)
          board (:board db)
          new-board (assoc board [x y] turn)
          winner (winner new-board)]
      (-> db
        (assoc :turn (rotate turn))
        (assoc :board new-board)
        (assoc :winner winner)))))
