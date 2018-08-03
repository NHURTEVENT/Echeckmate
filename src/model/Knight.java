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
public class Knight extends Piece{

    public Knight(Position position, Color pieceColor, Board board) {
        super(position, PieceType.KNIGHT, pieceColor, board);
    }

    @Override
    public ArrayList<Direction> getPiecePossibleDirections() {
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(Direction.KNIGHT_DOWN_LEFT);
        directions.add(Direction.KNIGHT_DOWN_RIGHT);
        directions.add(Direction.KNIGHT_UP_LEFT);
        directions.add(Direction.KNIGHT_UP_RIGHT);
        directions.add(Direction.KNIGHT_LEFT_DOWN);
        directions.add(Direction.KNIGHT_RIGHT_DOWN);
        directions.add(Direction.KNIGHT_LEFT_UP);
        directions.add(Direction.KNIGHT_RIGHT_UP);
        return directions;
    }
    
}
