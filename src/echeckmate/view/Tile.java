/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echeckmate.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nico
 */
public class Tile extends JPanel {

    int x;
    int y;
    Color color;
    int CELLSIZE;

    public Tile(int x, int y, Color color, JPanel board) {
        this.CELLSIZE = board.getSize().height / 8;
        this.x = x * CELLSIZE;
        this.y = y * CELLSIZE;
        this.color = color;
        this.setBackground(color);
        //this.setLayout(new FlowLayout());
        //this.setSize(CELLSIZE, CELLSIZE);
        this.setVisible(true);
        board.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println("edt : "+SwingUtilities.isEventDispatchThread());
                CELLSIZE = board.getSize().height < board.getSize().width ?  board.getSize().height/8 : board.getSize().width/ 8;
                System.out.println(CELLSIZE);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void componentShown(ComponentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}

