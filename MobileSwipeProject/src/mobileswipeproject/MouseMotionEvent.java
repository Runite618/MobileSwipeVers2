/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileswipeproject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author matth
 */
public class MouseMotionEvent extends JPanel implements MouseListener, MouseMotionListener, Runnable {

    private int previousY, y;
    private static int count = 0;
    private String dir;
    private boolean changedDir = false;
    private static boolean flag = false;
    private static Timer timer;
    
    public static void myTimer() {
        TimerTask task;

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(count);
                flag = true;
            }
        };
        timer.schedule(task, 1000);
    }

    public void addDrags() {
        count++;
        timer.cancel();
        if(!flag) {
            myTimer();
        }
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
        if (!changedDir) {
            addDrags();
            changedDir = false;
        }
        if (changedDir) {
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

    @Override
    public void run() {
        myTimer();
    }
}
