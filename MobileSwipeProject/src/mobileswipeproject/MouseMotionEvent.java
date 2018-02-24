/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileswipeproject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author matth
 */
public class MouseMotionEvent extends JPanel implements MouseMotionListener{

    private int previousY;
    private boolean dirUp;
    private int count = 0;
    
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
        count++;
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
    
    public void noOfDrags(MouseEvent me) {
        System.out.println(count);
    }
}
