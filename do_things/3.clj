(defn dec-maker
  "Create a custom decrementor"
  [dec-by]
  #(- % dec-by))

(def dec9 (dec-maker 9))
(dec9 10)
