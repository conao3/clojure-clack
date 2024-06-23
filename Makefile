all:

.PHONY: format
format:
	cljstyle fix

.PHONY: lint
	clj-kondo --lint src

.PHONY: check
check: format lint

.PHONY: clean
clean:
	rm -rf target

.PHONY: build
build: clean
	clojure -T:build uberjar
