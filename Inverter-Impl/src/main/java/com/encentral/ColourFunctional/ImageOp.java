package com.encentral.ColourFunctional;

import com.encentral.InterfaceDir.ColourInvert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageOp implements ColourInvert {

    public static BufferedImage img = new BufferedImage(1,1,1);

    @Override
    public void invertImage(String path){
        try{
            img = ImageIO.read(new File(path));
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, p);
            }
        }

        try {
            File output_file = new File("images/negativeImage.png");
            ImageIO.write(img, "png", output_file);
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }


    }

    @Override
    public File getImage(){
        File output = new File("negativeResult.png");
        try{
            ImageIO.write(img,"png",output);
        }catch(IOException e){
            System.out.println("Error: " + e);
        }

        return output;
    }
}
