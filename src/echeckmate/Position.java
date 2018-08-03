/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echeckmate;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author Nico
 */
public class Position {

    private int x;
    private int y;
    private String id;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        calculateId(x, y);
    }

    public Position(String id) {
        this.id = id;
        calculateCoordinates(id);
    }
    
    

    public String calculateId(int x, int y) {
        String id = x >= 1 && x < 9 ? String.valueOf((char) (x + 64)) + y : null;
        if (id == null) {
            throw new UnsupportedOperationException("could not asses tile identifier: x="+x+" y="+y);
        }
        setId(id);
        return id;
    }
    
    private void recalculateId(){
        calculateId(this.x, this.y);
    }

    public Point2D calculateCoordinates(String id) {
        int x = id.charAt(0)-64;
        int y = Integer.parseInt(id.substring(1));
        this.x = x;
        this.y = y;
        return new Point(x, y);
    }
    
    private void recalculateCoordinates(){
        calculateCoordinates(this.id);
    }
    
    @Override
    public boolean equals(Object object){
        if(! (object instanceof Position))
            return false;
        Position position = (Position) object;
        return (position.id.equals(this.getId()) && position.getX() == this.getX() && position.getY() == this.getY());
    }
    
    public int hashCode(){
        int hash = 31*getId().hashCode();
        hash += 31*getX();
        hash += 31*getY();
        return hash;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
        recalculateId();
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
        recalculateId();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
        recalculateCoordinates();
    }
}
