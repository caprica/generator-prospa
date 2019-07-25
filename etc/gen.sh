#!/bin/bash

javaVersion=11
serverPort=8080

languages=( "java" "kotlin" "scala" "groovy" )
frameworks=( "javalin" "spring-boot" "spring-mvc" "vertx" )
frontends=( "react" "angular" "vue" )

rm -rf projects
rm -rf specs

mkdir projects
mkdir specs

pushd projects > /dev/null

for language in "${languages[@]}" ; do

    for framework in "${frameworks[@]}"; do

        for frontend in "${frontends[@]}"; do

            project="$language-$framework-$frontend"
            echo "Creating project '$project'..."

            spec="../../specs/$project.json"

            mkdir $project
            pushd $project > /dev/null

            echo "{" >> $spec
            echo "  \"groupId\"            : \"uk.co.caprica\"," >> $spec
            echo "  \"name\"               : \"spa-test\"," >> $spec
            echo "  \"projectVersion\"     : \"1.0.0-SNAPSHOT\"," >> $spec
            echo "  \"description\"        : \"SPA $language $framework $frontend\"," >> $spec
            echo "  \"language\"           : \"$language\"," >> $spec
            echo "  \"javaVersion\"        : \"$javaVersion\"," >> $spec
            echo "  \"framework\"          : \"$framework\"," >> $spec
            echo "  \"frontEnd\"           : \"$frontend\"," >> $spec
            echo "  \"frontEndPackageTool\": \"yarn\"," >> $spec
            echo "  \"packageName\"        : \"uk.co.caprica.spatest\"," >> $spec
            echo "  \"mainClassName\"      : \"Application\"," >> $spec
            echo "  \"serverPort\"         : $serverPort" >> $spec
            echo "}" >> $spec

            yo prospa --spec "$spec" --force

            popd > /dev/null
            echo

        done

    done

done

popd > /dev/null
