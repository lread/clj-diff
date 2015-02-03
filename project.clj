(defproject clj-diff "1.0.0-SNAPSHOT"
  :description "Sequential diff in Clojure."
  :url "http://github.com/brentonashworth/clj-diff"
  :source-paths ["src/clj"]
  :java-source-paths ["src/jvm"]
  :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]

  :dev-dependencies [[org.clojure/clojure "1.6.0"]
                     [marginalia "0.8.0"]
                     [lein-difftest "1.3.2-SNAPSHOT"]]

  :prep-tasks [["cljx" "once"] "javac" "compile"]
  :profiles {:dev {:plugins [[com.keminglabs/cljx "0.5.0"]]}}
  :cljx {:builds [{:source-paths ["src/cljx"]
                   :output-path "target/classes"
                   :rules :clj}

                  {:source-paths ["src/cljx"]
                   :output-path "target/classes"
                   :rules :cljs}]}
  )
