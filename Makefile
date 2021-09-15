DC=docker-compose

start:
	$(DC) -f ./docker-compose.yml up -d

stop:
	$(DC) down

kill:
	docker stop $$(docker ps -a -q)
