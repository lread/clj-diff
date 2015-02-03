(defproject clj-diff "1.0.0-SNAPSHOT"
  :description "Sequential diff in Clojure."
  :url "http://github.com/brentonashworth/clj-diff"
  :source-paths ["src/clj"]
  :java-source-paths ["src/jvm"]
  :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]
  :test-paths ["test/clj_diff/test"]
  :hooks [leiningen.cljsbuild]
  :prep-tasks [["cljx" "once"] "javac" "compile"]

  :profiles {:dev {:plugins [[com.keminglabs/cljx "0.5.0"]
                             [lein-difftest "2.0.0"]]
                   :source-paths ["test"]
                   :dependencies [[org.clojure/clojure "1.6.0"]
                                  [marginalia "0.8.0"]]}
             :clj {:source-paths ["src/clj" "target/generated/src/clj"]
                   :test-paths ["test/clj" "target/generated/test/clj"]}
             :cljs {:dependencies [[org.clojure/clojurescript "0.0-2760"]]
                    :plugins [[com.cemerick/clojurescript.test "0.3.3"]
                              [lein-cljsbuild "1.0.4"]]
                    :source-paths ["target/generated/src/cljs"
                                   "target/generated/test/cljs"]}}

  :cljsbuild {:builds
              {:dev {:source-paths ["target/generated/src/cljs"
                                    "target/generated/test/cljs"]
                     :compiler {:output-to "target/tests.js"
                                :optimizations :simple
                                :pretty-print true}}}
              :test-commands {"test" ["node" "target/tests.js"]}}

  :cljx {:builds [{:source-paths ["src/cljx"]
                                 :output-path "target/generated/src/clj"
                                 :rules :clj}
                                {:source-paths ["src/cljx"]
                                 :output-path "target/generated/src/cljs"
                                 :rules :cljs}
                                {:source-paths ["test/cljx"]
                                 :output-path "target/generated/test/clj"
                                 :rules :clj}
                                {:source-paths ["test/cljx"]
                                 :output-path "target/generated/test/cljs"
                                 :rules :cljs}]}

  :aliases {"clj-test" ["with-profile","clj","test"]
            "cljs-test" ["do" "cljx," "with-profile" "cljs" "cljsbuild" "test"]
            "clj-clean-test" ["do" "clean," "clj-test"]
            "cljs-clean-test" ["do" "clean," "cljs-test"]
            "all-tests" ["do" "clean," "clj-test," "cljs-test"]}

)
