package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Logic extends Adapter {
    @Getter
    private final JLabel moveInfo;
    @Getter
    private final JLabel colorInfo;
    @Getter
    private final JSlider stepTurtle;
    @Getter
    private final JComboBox degreeSet;
    @Getter
    private final Render render;
    @Getter
    private Color color;
    private int colorIndex;

    public Logic() {
        String[] degrees = {"0","5","10","45","90","180"};
        this.degreeSet = new JComboBox(degrees);
        this.degreeSet.setSelectedIndex(3);
        this.stepTurtle = new JSlider(0, 100, 10);
        this.stepTurtle.setMajorTickSpacing(10);
        this.stepTurtle.setSnapToTicks(true);
        this.moveInfo = new JLabel("Step:  Degrees: ");
        this.colorInfo = new JLabel();
        this.colorInfo.setOpaque(true);
        this.color = Color.RED;
        this.colorIndex = 0;
        this.moveInfo.setText("Step: " + this.stepTurtle.getValue() + "  Angle: 45");
        this.colorInfo.setBackground(this.color);
        this.render = new Render(500, 350, this);
    }

    public void repaint() {
        this.render.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(TurtlePaint.COLOR)) {
            this.changeColor();
            this.colorInfo.setBackground(this.color);
        }
        if (e.getActionCommand().equals(TurtlePaint.ACTION)) {
            this.updateLabel();
            this.render.drawLine();
        }
    }

    private void updateLabel() {
        int degrees = Integer.parseInt((String) Objects.requireNonNull(this.getDegreeSet().getSelectedItem()));
        this.moveInfo.setText("Step: " + this.stepTurtle.getValue() + "  Angle: " + degrees);
    }

    private void changeColor() {
        switch(this.colorIndex) {
            case(0):
                this.color = Color.GREEN;
                this.colorIndex++;
                break;
            case(1):
                this.color = Color.CYAN;
                this.colorIndex++;
                break;
            case(2):
                this.color = Color.MAGENTA;
                this.colorIndex++;
                break;
            default:
                this.color = Color.RED;
                this.colorIndex = 0;
        }
    }
}
