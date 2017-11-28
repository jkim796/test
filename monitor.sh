#!/bin/bash

inotifywait -m -e create --format '%w%f' /home/joon/test/ | while read NEWFILE
do
    echo file $NEWFILE has been created!
    #stat $NEWFILE
    python -c 'import test; test.func()' &
    echo $!
done
