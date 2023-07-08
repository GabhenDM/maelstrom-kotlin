#!/bin/bash

# http://mywiki.wooledge.org/BashFAQ/028
if [[ $BASH_SOURCE = */* ]]; then
    DIR=${BASH_SOURCE%/*}/
else
    DIR=./
fi

# {"dest":"n1","body":{"type":"init","node_id":"n1","node_ids":["n1"],"msg_id":1},"src":"c1"}
exec java -Xmx256M -jar "$DIR/build/libs/maelstrom-server-1.0-SNAPSHOT.jar"