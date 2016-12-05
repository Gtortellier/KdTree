package kdtree;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main 
{
	public static void main(String[] args)
    {
        System.out.println("Entrer le nom de l'image à charger :");
        String filename = new Scanner(System.in).nextLine();
        
        try{
            File pathToFile = new File(filename);
            BufferedImage img = ImageIO.read(pathToFile);

            int imgHeight = img.getHeight();
            int imgWidth  = img.getWidth();
            BufferedImage res_img = new BufferedImage(imgWidth, imgHeight, img.getType());
            BufferedImage id_img = new BufferedImage(imgWidth, imgHeight, img.getType());
            
            ArrayList<Point3i> PointsImage = new ArrayList<Point3i>();
            for (int j = 0;j<imgHeight; j++) {
                for (int i = 0; i < imgWidth; i++) {
                    int Couleur = img.getRGB(i,j);
                    int Rouge = (Couleur >> 16) & 0xff;
                    int Vert = (Couleur >> 8) & 0xff;
                    int Bleu = Couleur & 0xff;
                    PointsImage.add(new Point3i(Rouge,Vert,Bleu));                
                }
                }

/////////////////////////////////////////////////////////////////
//TODO: replace this naive image copy by the quantization
/////////////////////////////////////////////////////////////////
            /** Recursively create a balanced subtree. 
            *
            *  If too many point remains when the maximal depth is reached, 
            *  replace the remaining point by their barycenter.
            *
            * @param points the points to be inserted in the subtree
            * @param depth the depth of the root of the subtree once inserted in the main tree
            * @param max_depth the maximal depth of the kdtree
            * @return the KdNode that correspond to the root of the subtree
            */
            
           
        	   

/////////////////////////////////////////////////////////////////

            ImageIO.write(id_img, "jpg", new File("ResId.jpg"));
            ImageIO.write(res_img, "jpg", new File("ResColor.jpg"));
/////////////////////////////////////////////////////////////////
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
