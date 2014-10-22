import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SecretDecoder{
    public static void main(String[] args){
	//Checking section
	//If there are not four arguments
	if(args.length!=4){
	    System.err.println("Input requires four commands in this order: the name of the image file you want to decode, the name of the color you want to decode, the name of the color you want to decode to, and the name of the decoded image file.");
	    System.exit(0);
	}

	//Four arguments of array
	String orig_image_file = args[0];
	String orig_color = args[1];
	orig_color = orig_color.toLowerCase();
	String new_color = args[2];
	new_color = new_color.toLowerCase();
	String new_image_file = args[3];
	BufferedImage decoded_image;
	
	//If the user tries to save new image as wrong file type
	if(new_image_file.contains(".png")||new_image_file.contains(".jpg")){
	}
        else{
	System.err.println("Please make sure the destination file is an image file (\".png\" or \".jpg\").");
	System.exit(0);
	}

	//If the user tries to decode to the same color
	if(orig_color.equals(new_color)){
	    System.err.println("The color you want to decode to cannot be the same as the color you are decoding from. Your message would still be hidden.");
	    System.exit(0);
	}
	
	//If the user uses the right colors
	if(orig_color.equals("green")||orig_color.equals("white")||orig_color.equals("red")||orig_color.equals("blue")||orig_color.equals("cyan")||orig_color.equals("gray")){
	}
	else{
	    System.err.println("Sorry, the only colors you can choose from are green, white, red, blue, cyan, and gray.");
	    System.exit(0);
	}

	if(new_color.equals("green")||new_color.equals("white")||new_color.equals("red")||new_color.equals("blue")||new_color.equals("cyan")||new_color.equals("gray")){
	}
	else{
	    System.err.println("Sorry, the only colors you can choose from are green, white, red, blue, cyan, and gray.");
	    System.exit(0);
	}
	
	//Manipulating section
	//Create a new instance of the Manipulate class that I created
	Manipulate buffered_image = new Manipulate(orig_image_file);
	
	//Take in the color of each pixel and store in array
	buffered_image.color_map();
	
	//Change color of pixels
	buffered_image.change_color(orig_color, new_color);
	
	//Save the image as the file name the user asked for
	decoded_image = buffered_image.get_new_image();
	Save saved_image = new Save(decoded_image);
	saved_image.imagesaver(new_image_file);
	System.out.println("Your image has been decoded as " + new_image_file + ". Thank you for using SecretDecoder!");
    }
}