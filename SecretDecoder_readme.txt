   Instructions for running SecretDecoder:

1. First, compile all of the source files in the Meyer_p1 to ensure that the program runs correctly.
	- Type "make compile" into the SSH (You should see a message appear that reads "javac *.java")
2. Then, run the example of the program that will decode the "tester.png" file automatically
	- Type "make run" into the SSH (You should see a message appear that reads "java SecretDecoder tester.png green blue tester_decoded.png
Your image has been decoded as tester_decoded.png. Thank you!")
	- If you check the "tester_decoded.png" file, the background will now be blue and the text will remain green
3. If you would like to run the program with your custom file, you can manually type in the arguments:
	- Type "java SecretDecoder your_image.png orig_color new_color your_new_image.png"
	- Replace "your_image.png" with the name of the image file you would like to decode
	- Replace "orig_color" with the color that the image currently is (the color you would like to decode from)
	- Replace "new_color" with the color that you want the background to change to (the color you would like to decode to)
	- Replace "your_new_image.png" with the desired name of the new decoded image file

   Thank you for using SecretDecoder!
   Jake Meyer