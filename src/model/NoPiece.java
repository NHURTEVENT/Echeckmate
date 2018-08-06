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
public class NoPiece extends Piece{

    public NoPiece(Position position, Board board) {
        super(position, PieceType.NONE , Color.green, board);
    }

    @Override
    public ArrayList<Direction> getPiecePossibleDirections() {
            return new ArrayList<>();
    }
    
}
