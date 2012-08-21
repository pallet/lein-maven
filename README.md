# lein-maven

A lein2 plugin for working with maven poms.

## Install

```clojure
:plugins [[lein-maven "0.1.0"]]
```
## Usage

To generate a project.clj from a pom, lein2 mvn in the directory with the pom
file.

To use maven based project checkouts, add the following middleware to your
`:user` profile in `~/.lein/profiles.clj`.

```clojure
:middleware [leiningen.mvn/maven-checkouts]
```

## Other lein plugins for working with maven

- [lein-nevam](https://github.com/thickey/lein-nevam)
- [lein-mvn](https://github.com/fabiokung/lein-mvn)

## License

Copyright © 2012 Hugo Duncan

Distributed under the Eclipse Public License.
