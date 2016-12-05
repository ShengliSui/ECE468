java -cp lib/antlr.jar:classes/ Micro testcases/input/factorial2.micro > test_output_folder/our.out_file/factorial2.out
tiny test_output_folder/our.out_file/factorial2.out < testcases/input/factorial2.input >  test_output_folder/our_final1

java -cp lib/antlr.jar:classes/ Micro testcases/input/fibonacci2.micro > test_output_folder/our.out_file/fibonacci2.out
tiny test_output_folder/our.out_file/fibonacci2.out < testcases/input/fibonacci2.input >  test_output_folder/our_final2

java -cp lib/antlr.jar:classes/ Micro testcases/input/fma.micro > test_output_folder/our.out_file/fma.out
tiny test_output_folder/our.out_file/fma.out < testcases/input/fma.input >  test_output_folder/our_final3


