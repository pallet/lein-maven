#!/bin/bash

# finish the release after updating release notes

if [[ $# -lt 1 ]]; then
  echo "usage: $(basename $0) new-version" >&2
  exit 1
fi

version=$1

echo "finish release of $version"

echo -n "commiting project.clj, release notes and readme.  enter to continue:" \
&& read x \
&& git add project.clj ReleaseNotes.md README.md \
           clj-mvn/project.clj src/leiningen/mvn.clj \
&& git commit -m "Updated project.clj, release notes and readme for $version" \
&& echo -n "Peform release.  enter to continue:" && read x \
&& cd clj-mvn \
&& lein2 test \
&& lein2 deploy clojars \
&& cd .. \
&& lein2 test \
&& lein2 deploy clojars \
&& git flow release finish $version \
&& echo "Now push to github. Don't forget the tags!"
