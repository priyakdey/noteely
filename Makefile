.DEFAULT_GOAL: help
.PHONY: setup teardown help build test

help:
	@echo "Usage: make <goal>"
	@echo "  setup                  setup local infrastructure"
	@echo "  teardown               teardown local infrastructure"
	@echo "  build                  build the java application"
	@echo "  test                   run the unit test suite"
	@echo "  integrationTest        run the integration test suite"
	@echo "  runTests               run all test suite"
	@echo "  clean                  deletes the build/ directory"

setup:
	@docker-compose -f ./infra/docker-compose.yml --env-file ./infra/.mongo.env up -d

teardown:
	@docker-compose -f ./infra/docker-compose.yml down -v

test:
	@./gradlew test --no-build-cache --rerun-tasks

integrationTest:
	@./gradlew integrationTest --no-build-cache --rerun-tasks

runTests: test integrationTest

build: clean
	@./gradlew clean build --exclude-task test --exclude-task integrationTest --info --no-build-cache --rerun-tasks

clean:
	@[ ! -d "./build" ] || rm -r build/

