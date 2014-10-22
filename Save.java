import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class Save{
    //Introduce new buffered image with new nae
    private BufferedImage new_buff_image;
    private String new_image_name;
    
    //Create constructor to introduce Save class
    public Save(BufferedImage image){
	this.new_buff_image = image;
    }
    
    //Method to write new buffered and manipulated image as a new file
    public void imagesaver(String name){
	this.new_image_name = name;
	    try{
		ImageIO.write(new_buff_image, "png", new File(new_image_name));
	    }
	    catch(IOException e){
		System.out.println("The desired output file is invalid. Please try running the program again.");
		System.exit(0);
	    }
    }
}