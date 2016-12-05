#!/bin/bash
declare -a arr=("factorial2" "fibonacci2" "fma" "step4_testcase" "step4_testcase2" "step4_testcase3" "test_adv" "test_dowhile" "test_expr" "test_if")

for i in "${arr[@]}"
do
  echo ****Test $i*****
  java -cp lib/antlr.jar:classes/ Micro testcases/inputs/$i.micro > test_output_folder/our.out_file/$i.out

  tiny4R test_output_folder/our.out_file/$i.out < testcases/inputs/$i.input > test_output_folder/our_final_$i

  tiny4R testcases/outputs/$i.out < testcases/inputs/$i.input > test_output_folder/real_final_$i

  if [[ $(head -1  test_output_folder/real_final_$i) = $(head -1 test_output_folder/our_final_$i) ]]; then
       echo -e "pass $i \n "
  else
       echo -e "failed $i \n"
  fi
done



