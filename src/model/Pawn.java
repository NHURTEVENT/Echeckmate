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

/**
 *
 * @author Nico
 */
public class Pawn extends Piece {

    boolean neverMoved;
    Direction movingDirection;

    public Pawn(Position position, Color pieceColor, Board board) {
        super(position, PieceType.PAWN, pieceColor, board);
        neverMoved = true;
        movingDirection = position.getY() == 7 ? Direction.UP : Direction.DOWN;
    }

    @Override
    public boolean isEmpty(Position position){
        return true;
    }
    
    @Override
    public ArrayList<Direction> getPiecePossibleDirections() {
        ArrayList<Direction> directions = new ArrayList<>();
        if (movingDirection == Direction.DOWN) {
            directions.add(Direction.DOWN);
            directions.add(Direction.DIAG_DOWN_LEFT);
            directions.add(Direction.DIAG_DOWN_RIGHT);
        } else {
            directions.add(Direction.UP);
            directions.add(Direction.DIAG_UP_LEFT);
            directions.add(Direction.DIAG_UP_RIGHT);
        }
        return directions;
    }

    @Override
    public ArrayList<Position> getPossiblePositions() {
        ArrayList<Position> positions = new ArrayList<>();
        Position pos = null;
        if (neverMoved) {
            if (movingDirection == Direction.UP) {
                pos = getPositionAfterMove(Direction.UP, 2);
                if(getPositionAfterMove(Direction.UP, 1) != null && getBoard().isEmpty(pos)&& getBoard().isEmpty(getPositionAfterMove(Direction.UP, 1)))
                    positions.add(pos);
            } else {
                pos = getPositionAfterMove(Direction.DOWN, 2);
                if(getPositionAfterMove(Direction.DOWN, 1) != null && getBoard().isEmpty(pos)&& getBoard().isEmpty(getPositionAfterMove(Direction.DOWN, 1)))
                    positions.add(pos);
            };
        }

        if (movingDirection == Direction.UP) {
            pos = getPositionAfterMove(Direction.UP, 1);
                if(pos != null && getBoard().isEmpty(pos))
                    positions.add(pos);
            pos = getPositionAfterMove(Direction.DIAG_UP_LEFT, 1);
            if (pos != null && !getBoard().isEmpty(pos) && getBoard().getTiles().get(pos).getPiece().getPieceColor() != getPieceColor()) {
                positions.add(pos);
            }
            //do same for right
            pos = getPositionAfterMove(Direction.DIAG_UP_RIGHT, 1);
            if (pos != null && !getBoard().isEmpty(pos) && getBoard().getTiles().get(pos).getPiece().getPieceColor() != getPieceColor()) {
                positions.add(pos);
            }
            //then for both downl
        } else {
            pos = getPositionAfterMove(Direction.DOWN, 1);
                if(pos != null && getBoard().isEmpty(pos))
                    positions.add(pos);
            pos = getPositionAfterMove(Direction.DIAG_DOWN_LEFT, 1);
            if (pos != null && !getBoard().isEmpty(pos) && getBoard().getTiles().get(pos).getPiece().getPieceColor() != getPieceColor()) {
                positions.add(pos);
            }
            //do same for right
            pos = getPositionAfterMove(Direction.DIAG_DOWN_RIGHT, 1);
            if (pos != null && !getBoard().isEmpty(pos) && getBoard().getTiles().get(pos).getPiece().getPieceColor() != getPieceColor()) {
                positions.add(pos);
            }
        }
        for (Position position : positions) {
            if (position == null) {
                positions.remove(position);
            }
        }
        return positions;
        /*
        else {
            Position[] position = new Position[]{
            getPositionAfterMove(Direction.UP, 1),
            getPositionAfterMove(Direction.DOWN, 1),};
        for (Position position1 : position) {
            if (position1 != null) {
                positions.add(position1);
            }
        }
    }

    
        if () //en passant
        {
            for (Direction piecePossibleDirection : getPiecePossibleDirections()) {

            //if nevermoved up 2 || down 2 
            //else up 1 || down 1
            //if diag1 !empty && !friendly
            if (getPositionAfterMove(piecePossibleDirection, 1) != null) {
                positions.add(getPositionAfterMove(piecePossibleDirection, 1));
            }
        }
    }

    setPossiblePositions(positions);
    return positions ;*/
    }

}
