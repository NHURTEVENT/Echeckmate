/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import echeckmate.Direction;
import echeckmate.Position;
import echeckmate.view.PieceType;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Nico
 */
public class Board {

    private HashMap<Position, Tile> tiles;
    private ArrayList<Piece> pieces;
    
    public Board(){
        createTiles();
        createPieces();
    }
    
    public void createTiles(){
        setTiles(new HashMap<>());
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Color tileColor = (x % 2 == 0 && y % 2 == 1) || x % 2 == 1 && y % 2 == 0 ? Color.BLACK : Color.WHITE;
                Position position = new Position(x+1, y+1);
                Tile tile = new Tile(position, tileColor, new NoPiece(position, this), this );
                getTiles().put(position, tile);
            }
        }
    }
    
   
    public void resetBoard() {
                throw new UnsupportedOperationException("not implemented yet");
    }

    public boolean isEmpty(Position position) {
        Tile tile = getTiles().get(position);
        return getTiles().get(position).getPiece().getPieceType() == PieceType.NONE;
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

    /**
     * @return the pieces
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * @param pieces the pieces to set
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

}
