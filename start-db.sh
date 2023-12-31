#!/bin/bash

CONTAINER_NAME="blackjack21-database"
DB_NAME="blackjack21"
USER="postgres"
PASSWORD="postgres"

# shellcheck disable=SC2046
docker rm -f $(docker ps -a | grep $CONTAINER_NAME | awk '{print $1}')
sleep 2

# start mysql
docker run --name $CONTAINER_NAME -p 5432:5432 -d -e POSTGRES_PASSWORD=$PASSWORD \
  -e POSTGRES_USER=$USER -e POSTGRES_DB=$DB_NAME postgres:16.0
sleep 10

# shellcheck disable=SC2002
cat dump.sql | docker exec -i $CONTAINER_NAME psql -U $USER -d $DB_NAME