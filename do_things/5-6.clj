(defn generalized-matching-parts
  [part n]
  (loop [curr n
         final-matching-parts [part]]
    (if (< curr 2)
      final-matching-parts
      (recur (- curr 1)
             (set (into  final-matching-parts 
                         [{:name (clojure.string/replace (:name part) #"^1-" (str curr "-"))
                           :size (:size part)}]))))))

(generalized-matching-parts {:name "1-asd" :size 3} 3)

(+ 1 2)


(defn better-and-generalized-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts n]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [(generalized-matching-parts part n)])))
          []
          asym-body-parts))

(better-and-generalized-symmetrize-body-parts [{:name "1-ab" :size 1}
                                               {:name "1-cd" :size 2}
                                               {:name "asd" :size 3}
                                               {:name "qwe" :size 1}
                                               {:name "1-de" :size 2}]
                                              10)
