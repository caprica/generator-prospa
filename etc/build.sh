#!/bin/bash

languages=( "java" "kotlin" "scala" "groovy" )
frameworks=( "javalin" "spring-boot" "spring-mvc" "vertx" )
frontends=( "react" "angular" "ember" "vue" )

pushd projects > /dev/null

for language in "${languages[@]}" ; do

    for framework in "${frameworks[@]}"; do

        for frontend in "${frontends[@]}"; do

            project="$language-$framework-$frontend"
            echo "Building project '$project'..."

            pushd $project > /dev/null

            mvn clean install

            popd > /dev/null
            echo

        done

    done

done

popd > /dev/null
