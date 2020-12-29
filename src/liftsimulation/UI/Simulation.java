package liftsimulation.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simulation extends JFrame {

    private JButton runTheLiftButton;
    private JPanel rootPanel;
    private JButton writerButton;
    private JTextField textFieldForWriter;
    private JLabel textDisplay;
    private JButton changeColorTesterButton;
    private JLabel colorChangeText;

    private boolean testerBool = true;

    public Simulation() {

        add(rootPanel);
        setTitle(Settings.DISPLAY_NAME);
        setSize(Settings.WIDTH, Settings.HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Button
        runTheLiftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(rootPanel,"Testing!!!");
            }
        });

        // For the writer tester
        writerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textDisplay.setText(textFieldForWriter.getText());
            }
        });

        // For change color test
        changeColorTesterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(testerBool) {
                    colorChangeText.setBackground(Color.GREEN);
                    testerBool = false;
                } else {
                    colorChangeText.setBackground(Color.YELLOW);
                    testerBool = true;
                }
            }
        });
    }


}
