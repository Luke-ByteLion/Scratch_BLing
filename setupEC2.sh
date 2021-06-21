#!/usr/bin/env bash

kill -9 $(lsof -t -i:8080)
echo "Killed process running on port 8080"

sudo java -jar ~/target/scratchBling2-0.0.1-SNAPSHOT.jar
echo "Started server using java -jar command"