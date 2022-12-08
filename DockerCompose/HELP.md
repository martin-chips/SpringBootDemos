# Docker Compose Demo

1. make sure all docker environment is right, contain docker compose.
2. generate a jar package, put the jar package/Dockerfile/docker-compose.yml in one folder.
3. then run the command : `docker compose up`.

FQ:
1. get the error: `failed to solve with frontend dockerfile.v0: failed to create LLB definition: unexpected status code [manifests 8]: 403 Forbidden`
you can pull the jdk images manually by run the command : `docker pull openjdk:8`