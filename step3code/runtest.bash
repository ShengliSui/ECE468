#!/bin/bash
i=0;
j=(1 5 6 7 8 9 11 13 14 16 18 19 20 21)

while [ $i -le 13 ]
do
    echo "******Input${j[$i]}*******  " 
    java -cp lib/antlr.jar:classes/ Micro testcases/input/test${j[$i]}.micro
    echo ""
    echo "******Expected Output${j[$i]} is******* " 
    cat testcases/output/test${j[$i]}.out
    echo ""
    ((i++))
done

