package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class TurtlePaint {
    public static final String ACTION = "ACTION";
    public static final String COLOR = "COLOR";


    public TurtlePaint() {
        JFrame frame = new JFrame("Turtle paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1,6));


        JButton action = new JButton(ACTION);
        JButton colorChange = new JButton(COLOR);

        Logic logic = new Logic();
        action.addActionListener(logic);
        colorChange.addActionListener(logic);

        frame.add(logic.getRender(), BorderLayout.CENTER);
        menu.add(logic.getDegreeSet());
        menu.add(logic.getStepTurtle());
        menu.add(action);
        menu.add(logic.getMoveInfo());
        menu.add(colorChange);
        menu.add(logic.getColorInfo());


        frame.add(menu, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
