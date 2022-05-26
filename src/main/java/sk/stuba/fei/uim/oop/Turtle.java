package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.lang.Math;

public class Turtle {
    private int x;
    private int y;
    private int degrees;
    public Turtle(int x, int y, int degrees) {
        this.x = x;
        this.y = y;
        this.degrees += degrees;
    }

    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillOval(this.x-20, this.y-20, 40, 40);
        g.setColor(Color.BLACK);
        int xHead = this.x - (int)(Math.sin(Math.toRadians(this.degrees)) * 20) - 10;
        int yHead = this.y - (int)(Math.cos(Math.toRadians(this.degrees)) * 20) - 10;
        g.fillOval(xHead, yHead, 20, 20);
    }
}
