package liftsimulation.UI;

import liftsimulation.Building;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Simulation extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel simulationPage;
    private JPanel aboutPage;
    private JPanel buildingSpace;
    private JPanel controlSpace;
    private JButton updateFloorsButton;
    private JTextField enterNumberOfFloorsTextField;
    private JTextField a5TextField;
    private JButton updateLiftCapacityButton;
    private JTextField a20TextField;
    private JButton updateNumberOfPeopleButton;
    private JSlider simulationSpeed;
    private JLabel titleBuilding;
    private JLabel titleControls;

    ArrayList<JLabel> listOfFloorJLabel = new ArrayList<>();
    //TODO
    final AtomicInteger currentFloor = new AtomicInteger(0);
    final AtomicInteger targetF = new AtomicInteger(5);
    final AtomicInteger speed = new AtomicInteger(1);

    private int noOfFloors;
    private Building building;

    /**
     * Default constructor
     */
    public Simulation() {
        this.setTitle(Settings.DISPLAY_NAME);
        this.setSize(Settings.WIDTH, Settings.HEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.addDetailsToGUI();

        /**
         * Update number of floors to the building
         */
        updateFloorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int floors = Integer.parseInt(enterNumberOfFloorsTextField.getText());
                noOfFloors = floors;
                buildingSpace.removeAll();
                listOfFloorJLabel.clear();
                addFloors(floors);
                //TODO
                listOfFloorJLabel.get(floors).setBackground(Settings.liftColor);
                listOfFloorJLabel.get(floors).setForeground(Color.WHITE);
                SwingUtilities.updateComponentTreeUI(mainPanel);
            }
        });

        //TODO : testing out lift animation on this button
        updateNumberOfPeopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                liftMovingAnimation(targetF.get());
                System.out.println("button function: " + Thread.currentThread().getName());
            }
        });

        // For the simulation speed slider
        simulationSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                speed.set(simulationSpeed.getValue());
            }
        });
    }

    /**
     * Adds number of floors
     *
     * @param noOfFloors
     */
    public void addFloors(int noOfFloors) {
        building = new Building(noOfFloors);
        buildingSpace.setLayout(new BoxLayout(buildingSpace, BoxLayout.Y_AXIS));
        for (int i = noOfFloors; i >= 0; i--) {
            //TODO
            listOfFloorJLabel.add(new JLabel("Floor " + i + " |  No. of People on floor: " + getNoOFPeopleOnFloor(i)));
        }
        // For each floor label in building part of GUI
        for (JLabel jLabel : listOfFloorJLabel) {
            jLabel.setOpaque(true);
            jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            jLabel.setVerticalAlignment(JLabel.CENTER);
            jLabel.setHorizontalAlignment(JLabel.CENTER);
            jLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 14));
            jLabel.setPreferredSize(new Dimension((mainPanel.getWidth() / 4) * 2, 200));
            jLabel.setMaximumSize(new Dimension((mainPanel.getWidth() / 4) * 2, 200));
            jLabel.setForeground(Color.BLACK);
            jLabel.setBackground(Settings.buildingColor);
            buildingSpace.add(jLabel);
        }
        listOfFloorJLabel.get(noOfFloors).setBackground(Settings.liftColor);
        listOfFloorJLabel.get(noOfFloors).setForeground(Color.WHITE);
        currentFloor.set(0);
        //TODO
        targetF.set(5);
    }

    private String getNoOFPeopleOnFloor(int floorNo) {
        // TODO remove var = 0
//        System.out.println(building.getListOfFloors().size());
        int noOfPeople = building.getListOfFloors().get(building.getListOfFloors().size() - floorNo - 1).noOfPeopleOnFloor();
        return String.valueOf(noOfPeople);
    }

    private void addDetailsToGUI() {
        titleBuilding.setBorder(new MatteBorder(10, 0, 0, 0, Settings.borderColor));
        titleControls.setBorder(new MatteBorder(10, 0, 0, 0, Settings.borderColor));
        controlSpace.setBorder(new MatteBorder(10, 0, 10, 10, Settings.borderColor));
        buildingSpace.setBorder(new MatteBorder(10, 10, 10, 0, Settings.borderColor));
    }

    private void liftMovingAnimation(int targetFloor) {
        //TODO
        new Thread(new Runnable() {
            public void run() {
                try {
                    int floor = getCurrentFloor();
                    int simSpeed = 1000 / (getSpeed() * 5);
                    while (floor <= targetFloor) {
                        listOfFloorJLabel.get(listOfFloorJLabel.size() - floor - 1).setBackground(Settings.liftColor);
                        listOfFloorJLabel.get(listOfFloorJLabel.size() - floor - 1).setForeground(Color.WHITE);
                        SwingUtilities.updateComponentTreeUI(buildingSpace);
                        floor++;
                        Thread.currentThread().sleep(simSpeed);
                        if (floor != targetFloor + 1) {
                            listOfFloorJLabel.get(listOfFloorJLabel.size() - floor).setBackground(Settings.buildingColor);
                            listOfFloorJLabel.get(listOfFloorJLabel.size() - floor).setForeground(Color.BLACK);
                        }
                    }
                    currentFloor.set(targetFloor);
                    //TODO: just testing out current floor & target floor stuff
                    targetF.set(targetF.get() + 2);
                } catch (Exception e) {
                }
            }
        }).start();
    }

    /**
     * Getter
     *
     * @return currentFloor
     */
    private int getCurrentFloor() {
        return this.currentFloor.get();
    }

    private int getSpeed() {
        return this.speed.get();
    }
}
