/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echeckmate.view;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Nico
 */
public class PieceIconFactory {

    public static final PieceIconFactory INSTANCE = new PieceIconFactory();

    public PieceIconFactory() {

    }

    public static PieceIconFactory getInstance() {
        return INSTANCE;
    }
    
    public ImageIcon getIcon(PieceType type, Color color) {
        String colorId = color == Color.black ? "B" : "W";
        return createImageIcon("/pics/" + type + colorId+".png",type + colorId);
    }

    protected ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
