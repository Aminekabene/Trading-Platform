#!/usr/bin/env bash


# Please first copy the formatted content of README.md in a Word document
# Set the Word document to a PDF named homework.pdf at the root of this directory

set -e
set -v

rm homeworks-javasql.tar.gz || true

exclusions="--exclude=*.tar.gz --exclude=target --exclude=.idea --exclude=*.docx --exclude=*.iml"

tar $exclusions -czvf homework-javasql.tar.gz * .mvn
