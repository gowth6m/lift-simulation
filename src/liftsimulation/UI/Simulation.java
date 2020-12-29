package liftsimulation.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Simulation extends JFrame{
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel simulationPage;
    private JPanel aboutPage;
    private JPanel buildingSpace;
    private JPanel controlSpace;
    private JButton updateFloorsButton;
    private JTextField enterNumberOfFloorsTextField;

    /**
     * Default constructor
     */
    public Simulation() {
        this.setTitle(Settings.DISPLAY_NAME);
        this.setSize(Settings.WIDTH,Settings.HEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        updateFloorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int floors = Integer.parseInt(enterNumberOfFloorsTextField.getText());
                updateFloors(floors);
                SwingUtilities.updateComponentTreeUI(mainPanel);
            }
        });
    }

    public void addFloors(int noOfFloors) {
        buildingSpace.setLayout(new BoxLayout(buildingSpace, BoxLayout.Y_AXIS));

        ArrayList<JLabel> listOfBtns = new ArrayList<>();
        for(int i=noOfFloors; i >= 0; i--) {
            listOfBtns.add(new JLabel("Floor "+i));
        }

        for(JLabel jLabel:listOfBtns) {
            jLabel.setOpaque(true);
            jLabel.setBackground(Color.gray);
            jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            jLabel.setSize(300, 100);
            buildingSpace.add(jLabel);
        }
    }

    public void updateFloors(int noOfFloors) {
        buildingSpace.removeAll();
        addFloors(noOfFloors);
    }

}
