/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echeckmate.view;

import echeckmate.Position;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nico
 */
public class Board extends JPanel {

    //ArrayList<Tile> tiles;
    private HashMap<Position, Tile> tiles;
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
        int newSize = (d.width - player1Side.getWidth() - player2Side.getWidth()) > d.height ? d.height : (d.width - player1Side.getWidth() - player2Side.getWidth());
        newSize = newSize < 200 ? 200 : newSize;
        return new Dimension(newSize, newSize);
    }

    public Board() {
        tiles = new HashMap<>();
        mainPanel = new JPanel();
        this.setLayout(new GridBagLayout());
        mainPanel.setMinimumSize(new Dimension(600, 200));
        mainPanel.setLayout(new GridBagLayout());
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Color tileColor = (x % 2 == 0 && y % 2 == 1) || x % 2 == 1 && y % 2 == 0 ? Color.BLACK : Color.WHITE;
                //mainPanel.repaint();
/////
                //if(x%2 ==0)
                Position position = new Position(x+1, y+1);
                Tile tile = new Tile(position, tileColor, this, PieceType.NONE, Color.white);
                addToGUI(tile, x + 1, y);
                tiles.put(position, tile);
                //else
                //    addToGUI(new Tile(x, y, tileColor, this, PieceType.NONE), x+1, y);
            }
        }
        Color color = Color.black;
        //addPlayerSide(color);
        JFrame f = new JFrame();
        f.pack();
        f.setMinimumSize(new Dimension(600 + f.getInsets().left + f.getInsets().right, 200 + f.getInsets().top + f.getInsets().bottom));
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
        constr.weightx = 0;
        constr.weighty = 1;
        player1Side = new PlayerSide(color);
        getMainPanel().add(player1Side, constr);
        constr.weighty = 0;
        constr.weightx = 0;
        constr.fill = GridBagConstraints.NONE;

        getMainPanel().add(this, constr);
        constr.fill = GridBagConstraints.BOTH;

        constr.weightx = 0;
        constr.weighty = 1;
        Color otherPlayerColor = color == Color.white ? Color.black : color.white;
        player2Side = new PlayerSide(otherPlayerColor);
        getMainPanel().add(player2Side, constr);

        //f.setLayout(new FlowLayout());
        f.add(mainPanel);
        //f.add(new JLabel("hi"));
        f.pack();
        f.setVisible(true);
        //resetBoard(Color.white);
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

    private void addPlayerSide(Color player1Color) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 1;
        constraints.gridheight = 8;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        getMainPanel().add(new PlayerSide(player1Color), constraints);
        constraints.gridx = 10;
        Color otherPlayerColor = player1Color == Color.white ? Color.black : player1Color.white;
        getMainPanel().add(new PlayerSide(otherPlayerColor), constraints);

    }

    public void resetBoard(Color player1Color) {
        Tile tileA1 = getTiles().get(new Position("A1"));
        tileA1.setPiece(PieceType.ROOK, Color.white);
        Tile tileA2 = getTiles().get(new Position("B1"));
        tileA2.setPiece(PieceType.KNIGHT, Color.white);
        Tile tileA3 = getTiles().get(new Position("C1"));
        tileA3.setPiece(PieceType.BISHOP, Color.white);
        Tile tileA4 = getTiles().get(new Position("D1"));
        tileA4.setPiece(PieceType.QUEEN, Color.white);
        Tile tileA5 = getTiles().get(new Position("E1"));
        tileA5.setPiece(PieceType.KING, Color.white);
        Tile tileA6 = getTiles().get(new Position("F1"));
        tileA6.setPiece(PieceType.BISHOP, Color.white);
        Tile tileA7 = getTiles().get(new Position("G1"));
        tileA7.setPiece(PieceType.KNIGHT, Color.white);
        Tile tileA8 = getTiles().get(new Position("H1"));
        tileA8.setPiece(PieceType.ROOK, Color.white);
        Tile tileH1 = getTiles().get(new Position("A8"));
        tileH1.setPiece(PieceType.ROOK, Color.black);
        Tile tileH2 = getTiles().get(new Position("B8"));
        tileH2.setPiece(PieceType.KNIGHT, Color.black);
        Tile tileH3 = getTiles().get(new Position("C8"));
        tileH3.setPiece(PieceType.BISHOP, Color.black);
        Tile tileH4 = getTiles().get(new Position("D8"));
        tileH4.setPiece(PieceType.KING, Color.black);
        Tile tileH5 = getTiles().get(new Position("E8"));
        tileH5.setPiece(PieceType.QUEEN, Color.black);
        Tile tileH6 = getTiles().get(new Position("F8"));
        tileH6.setPiece(PieceType.BISHOP, Color.black);
        Tile tileH7 = getTiles().get(new Position("G8"));
        tileH7.setPiece(PieceType.KNIGHT, Color.black);
        Tile tileH8 = getTiles().get(new Position("H8"));
        tileH8.setPiece(PieceType.ROOK, Color.black);
        for (int i = 0; i < 8; i++) {
            String letter = String.valueOf((char)(i + 65));
            Tile tile = getTiles().get(new Position(letter + 2));
            tile.setPiece(PieceType.PAWN, Color.white);
        }
        for (int i = 0; i < 8; i++) {
            String letter = String.valueOf((char)(i + 65));
            Tile tile = getTiles().get(new Position(letter + 7));
            tile.setPiece(PieceType.PAWN, Color.black);
        }
        revalidate();
        repaint();
    }

    /**
     * @return the tiles
     */
    public HashMap<Position, Tile> getTiles() {
        return tiles;
    }

    /**
     * @param tiles the tiles to set
     */
    public void setTiles(HashMap<Position, Tile> tiles) {
        this.tiles = tiles;
    }

    public void resetBoardColors() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Color tileColor = (x % 2 == 0 && y % 2 == 1) || x % 2 == 1 && y % 2 == 0 ? Color.BLACK : Color.WHITE;
                getTiles().get(new Position(x+1, y+1)).setColor(tileColor);
            }
        }
    }

}
