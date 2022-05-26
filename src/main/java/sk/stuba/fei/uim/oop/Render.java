package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Render extends JPanel {
    private int x;
    private int y;
    private Color color;
    private Logic logic;
    private int degrees;
    private int stepSize;

    public Render(int x, int y, Logic logic) {
        this.x = x;
        this.y = y;
        this.logic = logic;
        this.color = logic.getColor();
    }

    public void drawLine() {
        this.degrees = Integer.parseInt((String) Objects.requireNonNull(this.logic.getDegreeSet().getSelectedItem()));
        this.stepSize = this.logic.getStepTurtle().getValue();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Turtle turtle = new Turtle(500, 350, 0);
        turtle.draw(g);
        this.repaint();
//        g.setColor(Color.GREEN);
//        g.fillOval(this.x-20, this.y-20, 20, 20);
    }
}
