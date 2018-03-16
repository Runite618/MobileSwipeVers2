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

    private int previousY, y;
    private int count = 0;
    private String dir;
    private boolean changedDir = false;

    public void addDrags() {
        count++;
        System.out.println(count);
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        previousY = y;
        y = me.getY();
        if (changedDir == false) {
            if (y < previousY) {
                if (dir == "down") {
                    changedDir = true;
                    addDrags();
                } else {
                    dir = "up";
                }
            } else if (y > previousY) {
                if (dir == "up") {
                    changedDir = true;
                    addDrags();
                } else {
                    dir = "down";
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(!changedDir) {
            addDrags();
            changedDir = false;
        }
        if(changedDir) {
            changedDir = false;
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
