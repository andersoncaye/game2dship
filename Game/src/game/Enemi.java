/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author anderson.caye
 */
public class Enemi extends JLabel implements Runnable{
    
    private final int INC_X = 3;
    private final int INC_Y = 3;
    
    private int screenSizeX = 0;
    private int screenSizeY = 0;
    
    private int incX = INC_X;
    private int incY = INC_Y;
    
    public Enemi(){
        super();
    
        setIcon(new ImageIcon(getClass().getResource("/game/vaca.gif")));
        setText(null);
        
        new Thread(this).start();
    }


    @Override
    public void run() {
        try {
            while (true) {
                if (getX() + getWidth() > screenSizeX) { incX = -INC_X; }
                if (getX() < 0) { incX = INC_X; }
                if (getY() + getHeight() > screenSizeY) { incY = -INC_Y; }
                if (getY() < 0) { incY = INC_Y;}
                    
                setLocation(getX() + incX, getY() + incY);

                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setSizeScreen(int screenSizeX, int screenSizeY){
        this.screenSizeX = screenSizeX;
        this.screenSizeY = screenSizeY;
    }
    
}
