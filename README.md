# clojure-clack

A lightweight Clojure web application stack built on Ring and Jetty.

## Overview

clojure-clack provides a structured foundation for building web applications in Clojure. It combines well-established libraries into a cohesive stack:

- **Ring + Jetty9** - HTTP server and request handling
- **Reitit** - Fast, data-driven routing
- **Muuntaja** - Content negotiation and JSON serialization with camelCase key transformation
- **Component** - Lifecycle management for stateful resources
- **Ring-logger** - Request/response logging middleware

## Requirements

- Clojure 1.11+
- Java 11+

## Getting Started

Clone the repository:

```bash
git clone https://github.com/conao3/clojure-clack.git
cd clojure-clack
```

Start the development server:

```bash
clojure -M:dev
```

The server will start on the default port. You can then access the endpoints:

- `GET /health` - Health check endpoint
- `GET /api/hello` - Hello greeting (JSON response)
- `GET /api/goodbye` - Goodbye greeting (JSON response)

## Project Structure

```
src/clack/
  core.clj           # Application entry point
  system.clj         # Component system definition
  router.clj         # Route definitions and middleware
  handler.clj        # Multimethod-based request handlers
  component/
    handler.clj      # Handler component
    server.clj       # Jetty server component
  handler/
    health.clj       # Health check handler
    api/
      greeting.clj   # API greeting handlers
```

## Configuration

Create a configuration file at `~/.config/clack/config.edn`:

```edn
{:server {:port 3000}}
```

## Running Tests

```bash
clojure -M:test
```

## Building

Build an uberjar for deployment:

```bash
clojure -T:build uber
```

Run the uberjar:

```bash
java -jar target/clack.jar
```

## License

Apache-2.0
