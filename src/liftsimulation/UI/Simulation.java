package liftsimulation.UI;

import javax.swing.*;

public class Simulation extends JFrame{
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel simulationPage;
    private JPanel aboutPage;
    private JPanel buildingSpace;
    private JPanel controlSpace;

    /**
     * Default constructor
     */
    public Simulation() {
        this.setTitle(Settings.DISPLAY_NAME);
        this.setSize(Settings.WIDTH,Settings.HEIGHT);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
    }


}
