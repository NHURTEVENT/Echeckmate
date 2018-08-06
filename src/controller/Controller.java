/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import echeckmate.Direction;
import echeckmate.Position;
import echeckmate.view.View;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import model.Board;
import model.Model;
import model.Piece;
import model.Tile;

/**
 *
 * @author Nico
 */
public class Controller implements Observer {

    Model model;
    View view;
    boolean moving;

    public Controller() {

        this.model = new Model();
        this.view = new View();
        addObservers();
        model.getBoard().resetBoard();
        //model.getBoard().getPieces().get(0).move(Direction.DOWN, 3);

    }

    public void addObservers() {
        for (Map.Entry<Position, Tile> tileMap : model.getBoard().getTiles().entrySet()) {
            Position position = tileMap.getKey();
            Tile tile = tileMap.getValue();
            tile.addObserver(this);
        }
        for (Piece piece : model.getBoard().getPieces()) {
            piece.addObserver(this);
        }
        for (Map.Entry<Position, echeckmate.view.Tile> tileMap : view.getBoard().getTiles().entrySet()) {
            Position position = tileMap.getKey();
            echeckmate.view.Tile tile = tileMap.getValue();
            tile.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(".mouseClicked()");
                    moving = !moving;
                    if(e.getSource()instanceof echeckmate.view.Tile)
                        System.out.println(".mouseClicked()");
                    if(moving){
                        echeckmate.view.Tile tile = (echeckmate.view.Tile) e.getSource();
                        Piece piece = model.getBoard().getTiles().get(tile.getPosition()).getPiece();
                        for (Position possiblePosition : piece.getPossiblePositions()) {
                            view.getBoard().getTiles().get(possiblePosition).setColor(Color.red);
                        }
                    }
                    else{
                        view.getBoard().resetBoardColors();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Tile) {
            Tile tile = (Tile) o;
            view.getBoard().getTiles().get(tile.getPosition()).setPiece(tile.getPieceType(), tile.getPieceColor());
        }
        if (o instanceof Piece){
            Piece piece = (Piece) o;
            view.getBoard().getTiles().get(piece.getPosition()).setPiece(piece.getPieceType(), piece.getPieceColor());
        }
    }
}
