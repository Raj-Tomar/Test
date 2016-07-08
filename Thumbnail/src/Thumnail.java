import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.imgscalr.Scalr;


public class Thumnail {

	public static void main(String[] args){
		File imagepath = new File("C:/Documents and Settings/Administrator/Desktop/New/G.jpg"); 
        BufferedImage sourceImage;
		try {
			
			sourceImage = ImageIO.read(imagepath);
			sourceImage = Scalr.resize(sourceImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 100, 100, Scalr.OP_BRIGHTER);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( sourceImage, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream("C:/Documents and Settings/Administrator/Desktop/New/Thumb.jpg"));
			stream.write(imageInByte);
			stream.close();
			 
			
			// Image Compress
			
			  File input = new File("C:/Documents and Settings/Administrator/Desktop/New/G.jpg");
		      BufferedImage image = ImageIO.read(input);
		      
		      File compressedImageFile = new File("C:/Documents and Settings/Administrator/Desktop/New/compress.jpg");
		      OutputStream os =new FileOutputStream(compressedImageFile);

		      Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
		      ImageWriter writer = (ImageWriter) writers.next();

		      ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		      writer.setOutput(ios);

		      ImageWriteParam param = writer.getDefaultWriteParam();
		      
		      param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		      param.setCompressionQuality(0.3f);
		      
		      
		      writer.write(null, new IIOImage(image, null, null), param);
		      
		      os.close();
		      ios.close();
		      writer.dispose();
		      			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
