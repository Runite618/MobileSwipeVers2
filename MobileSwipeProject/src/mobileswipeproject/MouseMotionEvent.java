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

    int previousY;
    boolean dirUp;
    
    @Override
    public void mouseDragged(MouseEvent me) {
        previousY = me.getY();
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
}
