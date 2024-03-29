#Simple makefile
#  Important: the lines containing commands must start with
#  a tab not spaces.
#  Note: lines that start with the pound symbol are comments

#Compile source code by typing the command make compile
compile:
	javac *.java

#Run the Hello java main class by typing the command make run
run:
	java SecretDecoder tester.png green blue tester_decoded.png

#Clean the compiled class files by typing the command make clean
clean:
	rm *.class
