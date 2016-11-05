java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/test_adv.micro > test_adv.out
tiny test_adv.out < testcases_step5/input/test_adv.input
tiny testcases_step5/output/test_adv.out < testcases_step5/input/test_adv.input

java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/test_if.micro > test_if.out
tiny test_if.out < testcases_step5/input/test_if.input
tiny testcases_step5/output/test_if.out < testcases_step5/input/test_if.input

java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/test_dowhile.micro > test_dowhile.out
tiny test_dowhile.out < testcases_step5/input/test_dowhile.input
tiny testcases_step5/output/test_dowhile.out < testcases_step5/input/test_dowhile.input

java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/step4_testcase.micro > step4_testcase.out
tiny step4_testcase.out < testcases_step5/input/step4_testcase.input
tiny testcases_step5/output/step4_testcase.out < testcases_step5/input/step4_testcase.input

java -cp lib/antlr.jar:classes/ Micro testcases_step5/input/step4_testcase2.micro > step4_testcase2.out
tiny step4_testcase2.out < testcases_step5/input/step4_testcase2.input
tiny testcases_step5/output/step4_testcase2.out < testcases_step5/input/step4_testcase2.input