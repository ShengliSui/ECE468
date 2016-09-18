#!/bin/bash
i=1;
while [ $i -le 21 ]
do
    echo -n "$i  "  
    res=$(java -cp lib/antlr.jar:classes/ Micro testcases/input/test$i.micro)
    echo -n $res; echo -n "  "
    cat testcases/output/test$i.out
    ((i++))
done
