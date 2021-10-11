/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author kevin
 */
public class imageNames {
    public static ImageIcon getImage(int w, int h, String s){
        BufferedImage img=null;
        try {
            switch(s){
                case "asterisk":
                case "ast":
                case "*":
                    img = ImageIO.read(new File("images/asterisk.png"));
                    
                    break;
                case "owl":
                    img = ImageIO.read(new File("images/owl.png"));
                    break;
                case "doubleLoop":
                case "Loop":
                case "double":
                    img = ImageIO.read(new File("images/doubleloop.png"));
                    break;
                case "?":
                case "question":
                case "questionmark":
                    img = ImageIO.read(new File("images/questionmark.png"));
                    break;
                case "bulb":
                case "lightbulb":
                    img = ImageIO.read(new File("images/lightbulb.png"));
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        return(icon);
    }
    
}
