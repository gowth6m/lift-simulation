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
    private JTextField liftCapacityTextField;
    private JButton updateLiftCapacityButton;
    private JTextField numberOfPeopleInTextField;
    private JButton updateNumberOfPeopleButton;

    /**
     * Default constructor
     */
    public Simulation() {
        this.setTitle(Settings.DISPLAY_NAME);
        this.setSize(Settings.WIDTH,Settings.HEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        /**
         * Update number of floors to the building
         */
        updateFloorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int floors = Integer.parseInt(enterNumberOfFloorsTextField.getText());
                buildingSpace.removeAll();
                addFloors(floors);
                SwingUtilities.updateComponentTreeUI(mainPanel);
            }
        });

        addDetailsToGUI();
    }

    /**
     * Adds number of floors
     * @param noOfFloors
     */
    public void addFloors(int noOfFloors) {
        buildingSpace.setLayout(new BoxLayout(buildingSpace, BoxLayout.Y_AXIS));

        ArrayList<JLabel> listOfBtns = new ArrayList<>();
        for(int i=noOfFloors; i >= 0; i--) {
            listOfBtns.add(new JLabel("Floor "+i));
        }

        for(JLabel jLabel:listOfBtns) {
            jLabel.setOpaque(true);
            jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            jLabel.setVerticalAlignment(JLabel.CENTER);
            jLabel.setFont(new Font("Monaco", Font.PLAIN, 14));
            jLabel.setPreferredSize(new Dimension(700, 200));
            jLabel.setMaximumSize(new Dimension(700, 200));
            jLabel.setForeground(new Color(0, 0, 0));
            jLabel.setBackground(new Color(205, 205, 205));
            buildingSpace.add(jLabel);
        }
    }

//    public void updateFloors(int noOfFloors) {
//        buildingSpace.removeAll();
//        addFloors(noOfFloors);
//    }
    private void addDetailsToGUI() {

    }
}
