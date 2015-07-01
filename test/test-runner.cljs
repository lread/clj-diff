(ns test-runner
  (:require
   [cljs.test :as test :refer-macros [run-tests] :refer [report]]
   [clj-diff.test.core]
   [clj-diff.test.miller]
   ))

(enable-console-print!)

;; TODO: fix me when I want to do browser testing
;; (defmethod report [::test/default :summary] [m]
;;   (println "\nRan" (:test m) "tests containing"
;;     (+ (:pass m) (:fail m) (:error m)) "assertions.")
;;   (println (:fail m) "failures," (:error m) "errors.")
;;   (aset js/window "test-failures" (+ (:fail m) (:error m))))

(defn runner []
  (println "Test run started")
  (test/run-tests
    (test/empty-env ::test/default)
    'clj-diff.test.core
    'clj-diff.test.miller
    )
  (println "Test run ended"))

(runner)
