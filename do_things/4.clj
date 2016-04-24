(defn mapset
  "Map into a set"
  [f arr]
  (set (map f arr)))

(mapset inc [1 1 2 2])

