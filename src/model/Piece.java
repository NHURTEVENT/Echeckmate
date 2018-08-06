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
        Position position;
        switch (direction) {
            case UP:
                position = moveUp(distance);
                break;
            case DOWN:
                position = moveDown(distance);
                break;
            case LEFT:
                position = moveLeft(distance);
                break;
            case RIGHT:
                position = moveRight(distance);
                break;
            case DIAG_UP_LEFT:
                position = moveDiagUpLeft(distance);
                break;
            case DIAG_DOWN_LEFT:
                position = moveDiagDownLeft(distance);
                break;
            case DIAG_UP_RIGHT:
                position = moveDiagUpRight(distance);
                break;
            case DIAG_DOWN_RIGHT:
                position = moveDiagDownRight(distance);
                break;
            case KNIGHT_UP_LEFT:
                position = moveKnightUpLeft();
                break;
            case KNIGHT_DOWN_LEFT:
                position = moveKnightDownLeft();
                break;
            case KNIGHT_UP_RIGHT:
                position = moveKnightUpRight();
                break;
            case KNIGHT_DOWN_RIGHT:
                position = moveKnightDownRight();
                break;
            case KNIGHT_LEFT_UP:
                position = moveKnightLeftUp();
                break;
            case KNIGHT_LEFT_DOWN:
                position = moveKnightLeftDown();
                break;
            case KNIGHT_RIGHT_UP:
                position = moveKnightRightUp();
                break;
            case KNIGHT_RIGHT_DOWN:
                position = moveKnightRightDown();
                break;
            default:
                position = null;
                break;
        }
        setPosition(position);

    }

    public abstract ArrayList<Direction> getPiecePossibleDirections();

    public ArrayList<Position> getPossiblePositions() {
        ArrayList<Position> positions = new ArrayList<>();
        for (Direction piecePossibleDirection : getPiecePossibleDirections()) {
            for (int i = 1; i < 8; i++) {
                Position pos = getPositionAfterMove(piecePossibleDirection, i);
                if (pos == null) 
                    break;
                positions.add(pos);
                if(!getBoard().isEmpty(pos))
                    break;
                
            }
        }
        setPossiblePositions(positions);
        return positions;
    }

    public Position getPositionAfterMove(Direction direction, int distance) {
        Position position;
        switch (direction) {
            case UP:
                position = moveUp(distance);
                break;
            case DOWN:
                position = moveDown(distance);
                break;
            case LEFT:
                position = moveLeft(distance);
                break;
            case RIGHT:
                position = moveRight(distance);
                break;
            case DIAG_UP_LEFT:
                position = moveDiagUpLeft(distance);
                break;
            case DIAG_DOWN_LEFT:
                position = moveDiagDownLeft(distance);
                break;
            case DIAG_UP_RIGHT:
                position = moveDiagUpRight(distance);
                break;
            case DIAG_DOWN_RIGHT:
                position = moveDiagDownRight(distance);
                break;
            case KNIGHT_UP_LEFT:
                position = moveKnightUpLeft();
                break;
            case KNIGHT_DOWN_LEFT:
                position = moveKnightDownLeft();
                break;
            case KNIGHT_UP_RIGHT:
                position = moveKnightUpRight();
                break;
            case KNIGHT_DOWN_RIGHT:
                position = moveKnightDownRight();
                break;
            case KNIGHT_LEFT_UP:
                position = moveKnightLeftUp();
                break;
            case KNIGHT_LEFT_DOWN:
                position = moveKnightLeftDown();
                break;
            case KNIGHT_RIGHT_UP:
                position = moveKnightRightUp();
                break;
            case KNIGHT_RIGHT_DOWN:
                position = moveKnightRightDown();
                break;
            default:
                return null;
        }
        return position == null || isFriendly(position) ? null:position;
    }
    
    public boolean isEmpty(Position position){
        return getBoard().isEmpty(position);
    }
    
    public boolean isFriendly(Position position){
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

    public Position moveUp(int distance) {
        if (getPosition().getY() - distance < 1) {
            System.out.println("out of board's bounds");
            return null;
        }
        return new Position(this.getPosition().getX(), this.getPosition().getY() - distance);
    }

    public Position moveDown(int distance) {
        if (getPosition().getY() + distance > 8) {
            System.out.println("out of board's bounds");
            return null;
        }
        return new Position(this.getPosition().getX(), this.getPosition().getY() + distance);
    }

    public Position moveLeft(int distance) {
        if (getPosition().getX() - distance < 1) {
            System.out.println("out of board's bounds");
            return null;
        }
        return new Position(this.getPosition().getX() - distance, this.getPosition().getY());
    }

    public Position moveRight(int distance) {
        if (getPosition().getX() + distance > 8) {
            System.out.println("out of board's bounds");
            return null;
        }
        return new Position(this.getPosition().getX() + distance, this.getPosition().getY());
    }

    public Position moveUp(Position position, int distance) {
        if (position == null || position.getY() - distance < 1) {
            System.out.println("out of board's bounds");
            return null;
        }
        return new Position(position.getX(), position.getY() - distance);
    }

    public Position moveDown(Position position, int distance) {
        if (position == null || position.getY() + distance > 8) {
            System.out.println("out of board's bounds");
            return null;
        }
        return new Position(position.getX(), position.getY() + distance);
    }

    public Position moveLeft(Position position, int distance) {
        if (position == null || position.getX() - distance < 1) {
            System.out.println("out of board's bounds");
            return null;
        }
        return new Position(position.getX() - distance, position.getY());
    }

    public Position moveRight(Position position, int distance) {
        if (position == null || position.getX() + distance > 8) {
            System.out.println("out of board's bounds");
            return null;
        }
        return new Position(position.getX() + distance, position.getY());
    }

    public Position moveDiagUpLeft(int distance) {
        return moveUp(moveLeft(distance), distance);
    }

    public Position moveDiagDownLeft(int distance) {
        return moveDown(moveLeft(distance), distance);
    }

    public Position moveDiagUpRight(int distance) {
        return moveUp(moveRight(distance), distance);
    }

    public Position moveDiagDownRight(int distance) {
        return moveDown(moveRight(distance), distance);
    }

    public Position moveKnightUpLeft() {
        return moveUp(moveLeft(1), 2);
    }

    public Position moveKnightDownLeft() {
        return moveDown(moveLeft(1), 2);
    }

    public Position moveKnightUpRight() {
        return moveUp(moveRight(1), 2);
    }

    public Position moveKnightDownRight() {
        return moveDown(moveRight(1), 2);
    }

    public Position moveKnightLeftUp() {
        return moveUp(moveLeft(2), 1);
    }

    public Position moveKnightLeftDown() {
        return moveDown(moveLeft(2), 1);
    }

    public Position moveKnightRightUp() {
        return moveUp(moveRight(2), 1);
    }

    public Position moveKnightRightDown() {
        return moveDown(moveRight(2), 1);
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
