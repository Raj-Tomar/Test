import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailtorTest {

	public static void main(String[] args) {
		
		try {
			/*
			Thumbnails.of(new File("C:/Documents and Settings/Administrator/Desktop/New/bike.jpg"))
			.forceSize(100, 100)
			.outputQuality(1.0f)
			.toFile(new File("C:/Documents and Settings/Administrator/Desktop/New/T_bike.jpg"));
			*/
			
			File imagepath = new File("C:/Documents and Settings/Administrator/Desktop/New/T_watch.jpg");
			BufferedImage originalImage = ImageIO.read(imagepath);

			BufferedImage thumbnail = Thumbnails.of(originalImage)
					.forceSize(100, 100)
					.outputQuality(1.0f)
			        .asBufferedImage();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( thumbnail, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream("C:/Documents and Settings/Administrator/Desktop/New/T2_watch.jpg"));
			stream.write(imageInByte);
			stream.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
