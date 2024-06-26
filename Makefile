all:

.PHONY: format
format:
	cljstyle fix

.PHONY: lint
lint:
	clj-kondo --lint src

.PHONY: check
check: format lint

.PHONY: test
test:
	clojure -M:test --fail-fast

.PHONY: clean
clean:
	rm -rf target

.PHONY: build
build: clean
	clojure -T:build uberjar
