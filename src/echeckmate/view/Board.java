/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echeckmate.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nico
 */
public class Board extends JPanel{

    ArrayList<Tile> tiles;
    private JPanel mainPanel;
    private JPanel player1Side;
    private JPanel player2Side;

    public static void main(String[] args) {
        // TODO code application logic here
        new Board();
    }
    
     @Override
            public Dimension getPreferredSize() {
                // Relies on being the only component
                // in a layout that will center it without
                // expanding it to fill all the space.
                Dimension d = this.getParent().getSize();
                int newSize = (d.width-player1Side.getWidth()-player2Side.getWidth() )> d.height ? d.height : (d.width-player1Side.getWidth()-player2Side.getWidth() );
                newSize = newSize < 200 ? 200: newSize;
                return new Dimension(newSize, newSize);
            }

            
    public Board() {
        mainPanel = new JPanel();
        this.setLayout(new GridBagLayout());
        mainPanel.setMinimumSize(new Dimension(600, 200));
        mainPanel.setLayout(new GridBagLayout());
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x <8 ; x++) {
                Color tileColor = (x % 2 == 0 && y % 2 == 1) || x % 2 == 1 && y % 2 == 0 ? Color.BLACK : Color.WHITE;
                //mainPanel.repaint();
/////
                //if(x%2 ==0)
                    addToGUI(new Tile(x, y, tileColor, this, PieceType.ROOK), x+1, y);
                //else
                //    addToGUI(new Tile(x, y, tileColor, this, PieceType.NONE), x+1, y);
            }
        }
        Color color = Color.black;
        //addPlayerSide(color);
        JFrame f = new JFrame();
        f.pack();
        f.setMinimumSize(new Dimension(600+f.getInsets().left+f.getInsets().right, 200+f.getInsets().top +f.getInsets().bottom));
        //f.setLayout(new GridBagLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mainPanel.revalidate();
        //mainPanel.repaint();
        //JPanel p = new JPanel();
        //p.add(new JLabel("test"));
        //mainPanel.add(p);
        //addToGUI(p, 0, 0);
        this.setVisible(true);
        GridBagConstraints constr = new GridBagConstraints();
        constr.fill = GridBagConstraints.BOTH;
        constr.weightx =0;
        constr.weighty =1;
        player1Side = new PlayerSide(color);
        getMainPanel().add(player1Side,constr);
        constr.weighty=0;
        constr.weightx =0;        
        constr.fill = GridBagConstraints.NONE;


        getMainPanel().add(this, constr);
        constr.fill = GridBagConstraints.BOTH;

        constr.weightx =0;
        constr.weighty =1;
        Color otherPlayerColor = color == Color.white ? Color.black: color.white;
        player2Side = new PlayerSide(otherPlayerColor);
        getMainPanel().add(player2Side, constr);

        //f.setLayout(new FlowLayout());
        f.add(mainPanel);
        //f.add(new JLabel("hi"));
        f.pack();
        f.setVisible(true);

    }

    /**
     * Place the given component on the GUI at coordinates(x;y)
     *
     * @param component the component to add
     * @param column the x coordinate
     * @param row the y coordinate
     */
    private void addToGUI(Component component, int column, int row) {
        GridBagConstraints constraints = new GridBagConstraints();
        //constraints.insets = new Insets(2, 20, 2, 20);
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = column;
        constraints.gridy = row;
        component.setVisible(true);
        this.add(component, constraints);
    }

     private void add(Component component, int column, int row, Container container) {
        GridBagConstraints constraints = new GridBagConstraints();
        //constraints.insets = new Insets(2, 20, 2, 20);
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = column;
        constraints.gridy = row;
        component.setVisible(true);
        container.add(component, constraints);
    }
    
    
    /**
     * @return the mainPanel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * @param mainPanel the mainPanel to set
     */
    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    private void addPlayerSide(Color color) {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.weighty = 1;
            constraints.gridheight =8;
            constraints.weightx = 1;
            constraints.fill = GridBagConstraints.BOTH;
            constraints.gridx = 0;
            constraints.gridy = 0;
            getMainPanel().add(new PlayerSide(color), constraints);
            constraints.gridx = 10;
            Color otherPlayerColor = color == Color.white ? Color.black: color.white;
            getMainPanel().add(new PlayerSide(otherPlayerColor), constraints);

    }

   
}
