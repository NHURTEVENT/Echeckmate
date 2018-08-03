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
public class Queen extends Piece{

    public Queen(Position position, Color pieceColor, Board board) {
        super(position, PieceType.QUEEN, pieceColor, board);
    }

    @Override
    public ArrayList<Direction> getPiecePossibleDirections() {
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(Direction.UP);
        directions.add(Direction.DOWN);
        directions.add(Direction.RIGHT);
        directions.add(Direction.LEFT);
        directions.add(Direction.DIAG_DOWN_LEFT);
        directions.add(Direction.DIAG_DOWN_RIGHT);
        directions.add(Direction.DIAG_UP_LEFT);
        directions.add(Direction.DIAG_UP_RIGHT);
        return directions;   
    }
    
}
