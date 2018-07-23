/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echeckmate.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nico
 */

public class PlayerSide extends JPanel {

    Color color;

    public PlayerSide(Color color) {
        this.color = color;
        this.setMinimumSize(new Dimension(200, 200));
        this.setLayout(new FlowLayout());
        JLabel label = new JLabel("player X");
        drawIcon();
    }

    private void drawIcon() {
        PieceType piece = PieceType.ROOK;
        if (piece != PieceType.NONE) {
            ImageIcon icon = getIcon();
            Image image = icon.getImage();
            image = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);
            this.add(new JLabel(icon), BorderLayout.CENTER);
        }
    }

    private ImageIcon getIcon() {
        return PieceIconFactory.getInstance().getIcon(PieceType.ROOK, Color.black);
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
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

    @Override
    public Dimension getPreferredSize() {
        return super.getMinimumSize().width < 100 ? new Dimension(100, super.getMinimumSize().height) : super.getMinimumSize(); //To change body of generated methods, choose Tools | Templates.
    }
}
