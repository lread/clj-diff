(defproject clj-diff "1.1.0-SNAPSHOT"
  :description "Sequential diff in Clojure/Script."
  :url "http://github.com/rymndhng/clj-diff"
  :auto-clean false

  ;; optimizations
  :bootclasspath true
  :jar-exclusions [#"\.swp|\.swo|\.DS_Store|\.class"]

  ; Source code
  :source-paths      ["src/main/clojure"]
  :java-source-paths ["src/main/java"]
  :test-paths        ["src/test/clojure"]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "0.0-3308"]]

  :profiles {:dev {:dependencies [[marginalia "0.8.0"]]
                   :plugins [[lein-difftest "2.0.0"]
                             [lein-cljsbuild "1.0.6"]]}}

  :cljsbuild {:builds
              {:dev {:source-paths ["test" "src/test/clojure" "target/classes"]
                     :compiler {:output-to "target/testable.js"
                                :optimizations :simple
                                :pretty-print true}}}
              :test-commands {"unit-tests" ["node" "target/testable.js"]}})
