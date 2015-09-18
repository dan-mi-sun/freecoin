(defproject freecoin "0.2.0-SNAPSHOT"
  :description "Freecoin digital currency toolkit"
  :url "http://freecoin.ch"
  :license {:name "GNU GPL Affero v3 and "
            :url "http://www.d-centproject.eu"}
  :profiles {:dev [:dev-common :dev-local]
             :dev-common {:dependencies [[midje "1.6.3"]
                                         [peridot "0.3.1"]
                                         [kerodon "0.6.1"]]
                          :env [[:base-url "http://localhost:8000"]
                                [:client-id "QI7UVfyl6kepommh"]
                                [:client-secret "iEJGGyJwrB8bfIvC"]
                                [:auth-url "http://localhost:3000"]]
                          :plugins [[lein-midje "3.1.3"]]}
             :production [:user :dcent]
             :dcent {:env [[:base-url "http://localhost:8000"]
                           [:client-id "freecoin"]
                           [:client-secret "freecoin-secret"]
                           [:auth-url "fake stonecutter auth url"]]}

             :vm {:ring {:host "192.168.50.80"}}
             :uberjar {:aot :all
                       :main freecoin.main}}
  :plugins [[lein-ring "0.9.3"]
            [lein-environ "1.0.0"]]
  :ring {:reload-paths ["src"]
         :init freecoin.core/lein-ring-init
         :handler freecoin.core/lein-ring-handler
         :destroy freecoin.core/lein-ring-stop
         :port 8000}
  :source-paths ["src"]

  ;; :java-source-paths ["lib/java"]
  ;; :target-path "target/%s/"
  ;; :javac-options ["-target" "1.8" "-source" "1.8"])

  ;; make sure we use a proper source of random (install haveged)
  :jvm-opts ["-Djava.security.egd=file:/dev/random"]

  :dependencies [[org.clojure/clojure "1.6.0"]

                 ;; logging
                 [org.clojure/tools.logging "0.3.1"]
                 
                 ;; rest api
                 [liberator "0.12.2"]

                 ;; Routing
                 [scenic "0.2.5"]
                 
                 ;; liberator
                 [compojure "1.3.3"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-anti-forgery "1.0.0"]

                 ;; authentication
                 [com.cemerick/friend "0.2.1" :exclusions [robert/hooke xml-apis]]
                 [persona-kit "0.1.1-SNAPSHOT" :exclusions [com.cemerick/friend]]
                 [clj-oauth "1.5.1"]
                 [org.slf4j/slf4j-simple "1.7.12"]
                 [org.clojars.d-cent/stonecutter-oauth "0.1.8-SNAPSHOT"]
                 
                 ;; http client
                 [http-kit "2.1.18"]

                 ;; templating
                 [enlive "1.1.5"]
                 
                 ;; Form generation / validation
                 [formative "0.8.8"]
                 [formidable "0.1.9"]

                 ;; json marshalling
                 [cheshire "5.4.0"]

                 ;; json rendering
                 [json-html "0.2.8"]

                 ;; json normalizing
                 [autoclave "0.1.7"]

                 ;; json serialization and encryption
                 ;; [com.taoensso/nippy "2.8.0"]

                 ;; json schema validation
                 [prismatic/schema "0.4.2"]

                 ;; data storage
                 [com.novemberain/monger "2.0.0"]

                 ;; encryption
                 [org.clojure/math.numeric-tower "0.0.2"]
                 [com.tiemens/secretshare "1.3.1"]
                 [jstrutz/hashids "1.0.1"]

                 ;; date / time
                 [simple-time "0.2.0"]

                 ;; introspection
                 ;; [org.clojure/tools.namespace "0.2.10"]

                 ;; configuration
                 [environ "1.0.0"]

                 ;; human/machine interaction
                 [clojure-humanize "0.1.0"]

                 ;; qrcode
                 [clj.qrgen "0.3.0"]

                 ;; gravatar
                 [clavatar "0.2.1"]

                 ;; code analysis: call-graph
                 [cc.artifice/lein-gossip "0.2.1"]]
  :env [[:base-url "http://localhost:8000"]]

  ;; for running a production server using 'lein run'
  :aliases {"dev" ["with-profile" "dev" "ring" "server"]
            "run" ["with-profile" "production" "ring" "server"]})
