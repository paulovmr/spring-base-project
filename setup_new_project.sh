#!/bin/sh
die () {
    echo >&2 "$@"
    exit 1
}

[ "$#" -eq 1 ] || die "1 argument required, $# provided"

cd implementation/
shopt -s globstar
rename "s/baseproject/$1/" **
find . -type f -exec sed -i 's,baseproject,$1,g' {} \;
