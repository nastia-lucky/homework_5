For run the application you need follow the next steps: 

1. Build a docker image with the command "docker build -t spring-boot-docker:spring-docker ."
2. Find the created build with the help of the command "docker images"
3. Copy the id of built image {id}
4. Run the docker command "docker run -p 7070:7070 {id}"

Application should be started
