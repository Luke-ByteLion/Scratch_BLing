#!/usr/bin/env bash

mvn package
echo "Removed jar and rebuilt package..."

scp -i "/Users/lukemaclean/Downloads/scratch.pem" setupEC2.sh ec2-user@ec2-18-117-243-129.us-east-2.compute.amazonaws.com:/home/ec2-user
echo "Copied latest 'setupEC2.sh' file from local machine to ec2 instance"

scp -i "/Users/lukemaclean/Downloads/scratch.pem" target/scratchBling2-0.0.1-SNAPSHOT.jar ec2-user@ec2-18-117-243-129.us-east-2.compute.amazonaws.com:/home/ec2-user
echo "Copied lastest jar file from local machine to ec2 instance"

sudo ssh -i "/Users/lukemaclean/Downloads/scratch.pem" ec2-user@ec2-18-117-243-129.us-east-2.compute.amazonaws.com ./setupEC2.sh
echo "Connecting to ec2 instance and starting server using java -jar command"