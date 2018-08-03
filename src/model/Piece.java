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
public abstract class Piece extends Observable implements iPiece {

    private boolean alive;
    private Position position;
    private PieceType pieceType;
    private Color pieceColor;
    private ArrayList<Position> possiblePositions;
    private Board board;

    public Piece(Position position, PieceType pieceType, Color pieceColor, Board board) {
        this.position = position;
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        this.board = board;
    }

    @Override
    public void move(Direction direction, int distance) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public abstract ArrayList<Direction> getPiecePossibleDirections();

    public ArrayList<Position> getPossiblePositions() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public Position getPositionAfterMove(Direction direction, int distance) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public boolean isEmpty(Position position) {
        return getBoard().isEmpty(position);
    }

    public boolean isFriendly(Position position) {
        return getBoard().getTiles().get(position).getPiece().getPieceColor() == getPieceColor();
    }

    @Override
    public boolean canMoveHere(Position position) {
        for (Position possiblePosition : getPossiblePositions()) {
            if (possiblePosition == position && getBoard().isEmpty(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
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
        setChanged();
        notifyObservers();
    }

    /**
     * @return the pieceType
     */
    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * @param pieceType the pieceType to set
     */
    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
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
     * @param piecePossiblePositions the piecePossiblePositions to set
     */
    public void setPossiblePositions(ArrayList<Position> PossiblePositions) {
        this.possiblePositions = possiblePositions;
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
}
