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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author Nico
 */
public class Tile extends JPanel {

    int x;
    int y;
    String id;
    Color color;
    Color pieceColor;
    int CELLSIZE;
    private PieceType piece;
    Board board;

    public Tile(int x, int y, Color color, Board board, PieceType type, Color pieceColor) {
        
        this.board = board;
        this.CELLSIZE = board.getSize().height < board.getSize().width ? board.getSize().height / 8 : board.getSize().width / 8;
        this.x = x * CELLSIZE;
        this.y = y * CELLSIZE;
        this.id = calculateId(x,y);
        this.color = color;
        this.pieceColor = pieceColor;
        this.piece = type;
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        board.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                drawIcon();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
    }

    private ImageIcon getIcon() {
        return PieceIconFactory.getInstance().getIcon(getPiece(), pieceColor);
    }

    private SwingWorker createWorker() {
        return new SwingWorker<ImageIcon, Void>() {
            @Override
            protected ImageIcon doInBackground() throws Exception {
                
                ImageIcon icon = getIcon();
                Image image = icon.getImage();
                image = image.getScaledInstance(CELLSIZE, CELLSIZE, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(image);
                return icon;
            }

            @Override
            public void done() {
                try {
                    removeAll();
                    ImageIcon ico = get();
                    JLabel label = new JLabel(ico);
                    //TileLabel label = new TileLabel("ico");
                    label.setMinimumSize(new Dimension(CELLSIZE, CELLSIZE));
                    add(label, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
    }
    
    
    @Override
            public Dimension getPreferredSize() {
                // Relies on being the only component
                // in a layout that will center it without
                // expanding it to fill all the space.
                Dimension d = this.getParent().getSize();
                CELLSIZE = CELLSIZE < 25 ? 25: CELLSIZE;
                return new Dimension(CELLSIZE, CELLSIZE);
            }

    private void drawIcon() {
        CELLSIZE = board.getSize().height > board.getSize().width ? board.getSize().height / 8 : board.getSize().width / 8;
        if(piece != PieceType.NONE)
            createWorker().execute();
    }

    /**
     * @return the piece
     */
    public PieceType getPiece() {
        return piece;
    }

    /**
     * @param pieceType the piece to set
     */
    public void setPieceType(PieceType pieceType) {
        this.piece = pieceType;
    }
    
    /**
     * @param piece the piece to set
     */
    public void setPiece(PieceType pieceType, Color pieceColor) {
        this.piece = pieceType;
        this.pieceColor = pieceColor;
        drawIcon();
    }
    
    public String getId(){
        return this.id;
    }

    private String calculateId(int x, int y) {
         String id = x >= 0 && x <8  ? String.valueOf((char)(x + 65))+(8-y) : null;
         if(id == null)
             throw new UnsupportedOperationException("could not asses tile identifier");
         return id;
    }

}
