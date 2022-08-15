#!/bin/bash
curl -v -k --digest --user user:pass --header "Content-Type: application/json" --request POST --data \
'{"eventUUID":"38cf1e53-1de4-419d-87a9-9ef215fef06a","timestamp":"2022-08-05T13:33:36.722851+02:00","payload":"test1"}' \
https://localhost:8082/eventbus
