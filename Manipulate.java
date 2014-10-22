import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.awt.Color;

public class Manipulate{
    private BufferedImage image;
    private BufferedImage new_image;
    private int image_width;
    private int image_height;
    private int[][] image_color_map;

    public Manipulate(String image_name){
	//Buffer the image
	BufferedImage orig_buff_image = null;
	try{
	    orig_buff_image = ImageIO.read(new File(image_name));
	}
	catch(IOException e){
	    System.out.println("The program could not read the file you submitted. Make sure it is located in the correct directory. It also must be an image file(\".png\" or \".jpg\"). Please try running the program again.");
	    System.exit(0);
	}
	this.image = orig_buff_image;
    }
    
    //Find the width and height of the image
    //Take the color of each pixel and enter into a 2D array
    public void color_map(){
	this.image_width = image.getWidth();
	this.image_height = image.getHeight();
	int[][]image_color_map_holder = new int[image_height][image_width];
	for(int row=0; row<image_height; row++){
	    for(int col=0; col<image_width; col++){
		image_color_map_holder[row][col]=image.getRGB(col,row);
	    }
	}
	this.image_color_map = image_color_map_holder;
    }
    
    //Create a new buffered image of equal size
    //Set RGB values of each pixel to desired values
    public void change_color(String orig_color, String new_color){
	int orig_color_int=0;
	int new_color_int=0;
	
	//Convert user's input of color from String format to int format
	if(orig_color.equals("green")){
	    orig_color_int = 0xff00ff00;
	}
	if(orig_color.equals("white")){
	    orig_color_int = 0xffffffff;
	}
	if(orig_color.equals("red")){
	    orig_color_int = 0xffff0000;
	}
	if(orig_color.equals("blue")){
	    orig_color_int = 0xff0000ff;
	}
	if(orig_color.equals("cyan")){
	    orig_color_int = 0xff00ffff;
	}
	if(orig_color.equals("gray")){
	    orig_color_int = 0xff808080;
	} 

	if(new_color.equals("green")){
	    new_color_int = 0xff00ff00;
	}
	if(new_color.equals("white")){
	    new_color_int = 0xffffffff;
	}
	if(new_color.equals("red")){
	    new_color_int = 0xffff0000;
	}
	if(new_color.equals("blue")){
	    new_color_int = 0xff0000ff;
	}
	if(new_color.equals("cyan")){
	    new_color_int = 0xff00ffff;
	}
	if(new_color.equals("gray")){
	    new_color_int = 0xff808080;
	}
	
	//Replace the pure color pixels with new desired color
	BufferedImage new_image_holder = new BufferedImage(image_width, image_height, BufferedImage.TYPE_INT_ARGB);
	for(int row=0; row<image_height; row++){
	    for(int col=0; col<image_width; col++){
		if(image_color_map[row][col]==orig_color_int){
		    new_image_holder.setRGB(col, row, new_color_int);
		}
		else{
		    new_image_holder.setRGB(col,row,this.image_color_map[row][col]);
		}
	    }
	}
	this.new_image = new_image_holder;
    }
    
    //Return the manipulated image
    public BufferedImage get_new_image(){
	return new_image;
    }
}