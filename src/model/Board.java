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
    
    public void createPieces(){
        setPieces(new ArrayList<>());
        getPieces().add(new Rook(new Position("A1"), Color.white, this));
    }

    public void resetBoard() {
        Tile tileA1 = getTiles().get(new Position("A1"));
        Rook rookLW = new Rook(new Position("A1"),Color.white, this);
        getPieces().add(rookLW);
        tileA1.setPiece(rookLW);
        Tile tileB1 = getTiles().get(new Position("B1"));
        Knight knightLW = new Knight(new Position("B1"),Color.white, this);
        getPieces().add(knightLW);
        tileB1.setPiece(knightLW);
        Tile tileC1 = getTiles().get(new Position("C1"));
        Bishop bishopLW = new Bishop(new Position("C1"),Color.white, this);
        getPieces().add(bishopLW);
        tileC1.setPiece(bishopLW);
        Tile tileD1 = getTiles().get(new Position("D1"));
        Queen queenW = new Queen(new Position("D1"),Color.white, this);
        getPieces().add(queenW);
        tileD1.setPiece(queenW);
        Tile tileE1 = getTiles().get(new Position("E1"));
        King kingW = new King(new Position("E1"),Color.white, this);
        getPieces().add(kingW);
        tileE1.setPiece(kingW);
        Tile tileF1 = getTiles().get(new Position("F1"));
        Bishop bishopRW = new Bishop(new Position("F1"),Color.white, this);
        getPieces().add(bishopRW);
        tileF1.setPiece(bishopRW);
        Tile tileG1 = getTiles().get(new Position("G1"));
        Knight knightRW = new Knight(new Position("G1"),Color.white, this);
        getPieces().add(knightRW);
        tileG1.setPiece(knightRW);
        Tile tileH1 = getTiles().get(new Position("H1"));
        Rook rookRW = new Rook(new Position("H1"),Color.white, this);
        getPieces().add(rookRW);
        tileH1.setPiece(rookRW);
        Tile tileA8 = getTiles().get(new Position("A8"));
        Rook rookLB = new Rook(new Position("A8"),Color.black, this);
        getPieces().add(rookLB);
        tileA8.setPiece(rookLB);
        Tile tileB8 = getTiles().get(new Position("B8"));
        Knight knightLB = new Knight(new Position("B8"),Color.black, this);
        getPieces().add(knightLB);
        tileB8.setPiece(knightLB);
        Tile tileC8 = getTiles().get(new Position("C8"));
        Bishop bishopLB = new Bishop(new Position("C8"),Color.black, this);
        getPieces().add(bishopLB);
        tileC8.setPiece(bishopLB);
        Tile tileD8 = getTiles().get(new Position("D8"));
        Queen queenB = new Queen(new Position("D8"),Color.black, this);
        getPieces().add(queenB);
        tileD8.setPiece(queenB);
        Tile tileE8 = getTiles().get(new Position("E8"));
        King kingB = new King(new Position("E8"),Color.black, this);
        getPieces().add(kingB);
        tileE8.setPiece(kingB);
        Tile tileF8 = getTiles().get(new Position("F8"));
        Bishop bishopRB = new Bishop(new Position("F8"),Color.black, this);
        getPieces().add(bishopRB);
        tileF8.setPiece(bishopRB);
        Tile tileG8 = getTiles().get(new Position("G8"));
        Knight knightRB = new Knight(new Position("G8"),Color.black, this);
        getPieces().add(knightRB);
        tileG8.setPiece(knightRB);
        Tile tileH8 = getTiles().get(new Position("H8"));
        Rook rookRB = new Rook(new Position("H8"),Color.black, this);
        getPieces().add(rookRB);
        tileH8.setPiece(rookRB);
        
        for (int i = 0; i < 8; i++) {
            String letter = String.valueOf((char) (i + 65));
            Tile tile = getTiles().get(new Position(letter + 2));
            Pawn pawnW = new Pawn(new Position(letter+2),Color.white, this);
            getPieces().add(pawnW);
            tile.setPiece(pawnW);
        }
        for (int i = 0; i < 8; i++) {
            String letter = String.valueOf((char) (i + 65));
            Tile tile = getTiles().get(new Position(letter + 7));
            Pawn pawnB = new Pawn(new Position(letter+7),Color.black, this);
            getPieces().add(pawnB);
            //tile.setPiece(pawnB);
        }
       
        Tile tileB6 = getTiles().get(new Position("B6"));
        Knight knightF = new Knight(new Position("B6"),Color.black, this);
        getPieces().add(knightF);
        tileB6.setPiece(knightF);
        
        Tile tileD6 = getTiles().get(new Position("D6"));
        Knight knight = new Knight(new Position("D6"),Color.WHITE, this);
        getPieces().add(knight);
        tileD6.setPiece(knight);
        
        
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
