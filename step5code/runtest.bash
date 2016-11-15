#!/bin/bash
echo ****Test 1*****
java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/step4_testcase.micro > test_output_folder/our.out_file/1.out
tiny test_output_folder/our.out_file/1.out < testcases_step5/input/step4_testcase.input >  test_output_folder/our_final1
if [[ $(head -1  testcases_step5/output/step4_testcase.tinyout) = $(head -1 test_output_folder/our_final1) ]]; then
     echo "pass test 1"
else
     echo "failed"
fi

echo ****Test 2*****
java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/step4_testcase2.micro > test_output_folder/our.out_file/2.out
tiny test_output_folder/our.out_file/2.out < testcases_step5/input/step4_testcase2.input >  test_output_folder/our_final2 

if [[ $(head -1  testcases_step5/output/step4_testcase2.tinyout) = $(head -1 test_output_folder/our_final2) ]]; then
     echo "pass test 2"
else
     echo "failed"
fi

echo ****Test 3*****
java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/test_adv.micro > test_output_folder/our.out_file/3.out
tiny test_output_folder/our.out_file/3.out < testcases_step5/input/test_adv.input >  test_output_folder/our_final3
if [[ $(head -1 testcases_step5/output/test_adv.tinyout) = $(head -1 test_output_folder/our_final3) ]]; then
     echo "pass test 3"
else
     echo "failed"
fi


echo ****Test 4*****
java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/test_dowhile.micro > test_output_folder/our.out_file/4.out
tiny test_output_folder/our.out_file/4.out < testcases_step5/input/test_dowhile.input >  test_output_folder/our_final4

if [[ $(head -1 testcases_step5/output/test_dowhile.tinyout) = $(head -1 test_output_folder/our_final4) ]]; then
     echo "pass test 4"
else
     echo "failed"
fi

echo ****Test 5*****
java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/test_if.micro > test_output_folder/our.out_file/5.out
tiny test_output_folder/our.out_file/5.out < testcases_step5/input/test_if.input >  test_output_folder/our_final5

if [[ $(head -1 testcases_step5/output/test_if.tinyout) = $(head -1 test_output_folder/our_final5) ]]; then
     echo "pass test 5"
else
     echo "failed"
fi
