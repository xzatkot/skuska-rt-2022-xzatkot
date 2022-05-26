package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Render extends JPanel {
    private final int x;
    private final int y;
    private final Color color;
    private final Logic logic;
    @Getter
    private int degrees;
    private int stepSize;
    private Turtle turtle;

    public Render(int x, int y, Logic logic) {
        this.x = x;
        this.y = y;
        this.logic = logic;
        this.color = logic.getColor();
        this.degrees = 0;
        this.stepSize = 0;
    }

    public void drawLine() {
        this.degrees += Integer.parseInt((String) Objects.requireNonNull(this.logic.getDegreeSet().getSelectedItem()));
        this.stepSize = this.logic.getStepTurtle().getValue();
        this.repaint();
        this.turtle = new Turtle(this.x, this.y, this.degrees);
        this.turtle.draw(this.getGraphics());
//        int xPos = this.x + (int)(Math.sin(Math.toRadians(this.degrees)) * this.stepSize);
//        int yPos = this.y - (int)(Math.cos(Math.toRadians(this.degrees)) * this.stepSize);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.turtle = new Turtle(this.x, this.y, this.degrees);
        this.turtle.draw(g);
    }
}
