#!/bin/env bash

targets=(
        "www.naver.com:80"
)

for target in "${targets[@]}"
do
        host=${target%%:*}
        port=${target##*:}
        nc -z $host $port > /dev/null
        if [ $? -ne 0 ]; then
                echo "FAIL $target"
        fi
done
