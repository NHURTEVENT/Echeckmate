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
import java.util.Observable;

/**
 *
 * @author Nico
 */
public class Tile extends Observable{
    
    private Position position;
    private Color color;
    private Color pieceColor;
    private PieceType pieceType;
    private Board board;
    private Piece piece;

    /*public Tile(Position position, Color color, Color pieceColor, PieceType piece, Board board) {
        this.position = position;
        this.color = color;
        this.pieceColor = pieceColor;
        this.pieceType = piece;
        this.piece = new Piece(position, pieceType, pieceColor, board) {
            @Override
            public ArrayList<Direction> getPiecePossibleDirections() {
                return new ArrayList<>();
            }
        };
                
        this.board = board;
    }*/
    
    public Tile(Position position, Color color, Piece piece, Board board) {
        this.position = position;
        this.color = color;
        this.pieceColor = piece.getPieceColor();
        this.pieceType = piece.getPieceType();
        this.piece = piece;
                
        this.board = board;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the pieceColor
     */
    public Color getPieceColor() {
        return pieceColor;
    }

    /**
     * @param pieceColor the pieceColor to set
     */
    public void setPieceColor(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    /**
     * @return the piece
     */
    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * @param piece the piece to set
     */
    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }
    
    /**
     * @param pieceType
     * @param pieceColor
     */
    public void setPiece(PieceType pieceType, Color pieceColor) {
        this.setPieceType(pieceType);
        this.pieceColor = pieceColor;
        setChanged();
        notifyObservers();
    }
    
    public void setPiece(Piece piece){
        this.setPieceType(piece.getPieceType());
        this.pieceColor = piece.getPieceColor();
        this.piece = piece;
        setChanged();
        notifyObservers();
    }

    /**
     * @return the piece
     */
    public Piece getPiece() {
        return piece;
    }
}
