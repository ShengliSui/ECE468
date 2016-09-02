all : group compiler

group:
	echo "name: Chongjin Chua, login: chua1"

compiler: helloworld

helloworld: helloworld.c
	$(CC) -o $@ $<

clean:
	rm helloworld