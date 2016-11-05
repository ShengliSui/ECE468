#!/bin/bash
echo ****Test 1*****Nothing means good
java -cp lib/antlr.jar:classes/ Micro step4_testcase3.micro > out1.out
diff out1.out step4_testcase3.out

echo ****TEst 2*****Nothing means good
java -cp lib/antlr.jar:classes/ Micro test_expr.micro > out2.out
diff out2.out test_expr.out
