/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import echeckmate.Direction;
import echeckmate.Position;

/**
 *
 * @author Nico
 */
public interface iPiece {
    void move(Direction direction, int distance);
    boolean canMoveHere(Position position);
    boolean isAlive();
}
