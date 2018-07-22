/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echeckmate.view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nico
 */
public class PlayerSide extends JPanel{
    
    public PlayerSide(Color color){
        JLabel label = new JLabel("player X");
        label.setBackground(color);
        this.add(label);
        this.setBackground(Color.green);
    }
    
    
}
