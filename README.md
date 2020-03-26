# manualDockerCluster
Project run a app java in manual cluster with docker containers

## This project contains:
- java project with spring boot (3 instances in example)
- image mongo db
- image nginx configured with 

## initial configuration

If you want build images for learning:
```
  docker build -f nginx.dockerfile -t your_docker_hub .
  docker build -f Dockerfile -t your_docker_hub .  
```
  _*** you need have a docker hub account_

Running images from repository:
```
  # network create (for nginx, app and mongo communication is necessary create a network in docker)
  docker network create redeCarlitao

  # mongodb 
  docker run -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root --network=redeCarlitao --name mongozao mongo
  
  # containers apps (3 for simulate load balance)
  docker run --network=redeCarlitao --name stock1 carlitosbrossa/stock
  docker run --network=redeCarlitao --name stock2 carlitosbrossa/stock
  docker run --network=redeCarlitao --name stock3 carlitosbrossa/stock
  
  # nginx with load balance configuration
  docker run -p 80:80 --network=redeCarlitao carlitosbrossa/ngnix
```

## Testing:

1 - access url http://localhost/players/seed for populate mongo collection
2 - access url http://localhost/players for lista all collection created
3 - Note that application logs must follow round robin algorithm for load balance


