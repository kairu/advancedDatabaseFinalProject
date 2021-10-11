/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontPackage;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class fontStyles {
    public static Font setMaely(float size) throws FontFormatException, IOException{
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Maely.ttf")).deriveFont(Font.PLAIN, size);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);
        return(customFont);
    }
    
    public static Font setOpenSans(float size) throws FontFormatException, FontFormatException, IOException, IOException{
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/OpenSans.ttf")).deriveFont(Font.PLAIN, size);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);
        return(customFont);
    }
}
