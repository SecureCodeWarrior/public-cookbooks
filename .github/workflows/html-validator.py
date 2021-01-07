#!/usr/bin/env python3
import html5lib
import sys

def failed(msg):
    print(msg)
    sys.exit(1)

def succeeded():
    sys.exit(0)

# Main
if len(sys.argv) != 2:
    failed("Invalid arguments. Usage: %s <html_file_path>" % sys.argv[0])

parser = html5lib.HTMLParser(strict=True)
html_file_path = sys.argv[1]

with open(html_file_path, "rb") as html_file:
    try:
        parser.parse(html_file)
        succeeded()
    except html5lib.html5parser.ParseError as e:
        failed("Validation failed: %s" % e)
