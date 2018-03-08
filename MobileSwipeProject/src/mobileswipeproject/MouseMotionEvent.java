/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileswipeproject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author matth
 */
public class MouseMotionEvent extends JPanel implements MouseListener, MouseMotionListener{

    private int previousY;
    private boolean dirUp;
    private boolean dragging;
    private int count = 0;
    
    public boolean getDragging() {
        return dragging;
    }
    
    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }
    
    public int getCount() {
        return count;
    }
    
    public MouseMotionEvent() {
        
    }
    
    public MouseMotionEvent(int previousY, boolean dirUp, int count) {
        this.previousY = previousY;
        this.dirUp = dirUp;
        this.count = count;
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        previousY = me.getY();
        setDragging(true);
//        count++;
//        System.out.println(count);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(getDragging()) {
            setDragging(false);
            count++;
            System.out.println(count);
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent me) {
        int y = me.getY();
        if (y < previousY) {
            dirUp = true;
        }
        else if (y > previousY) {
            dirUp = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
