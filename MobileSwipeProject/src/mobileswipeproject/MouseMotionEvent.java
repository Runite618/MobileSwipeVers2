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
    private int count = 0;
    private String dir;

    @Override
    public void mouseDragged(MouseEvent me) {
        int y = me.getY();
        if (y < previousY) {
            dir = "up";
        }
        else if (y > previousY) {
            dir = "down";
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(dir == "up" || dir == "down") {
            count++;
            System.out.println(count);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        previousY = me.getY();
    }
    
    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
