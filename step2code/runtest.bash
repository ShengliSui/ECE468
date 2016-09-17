#!/bin/bash
i=1;
while [ $i -le 21 ]
do
echo -n "$i  "  
java -cp lib/antlr.jar:classes/ Micro testcases/input/test$i.micro
((i++))
done
