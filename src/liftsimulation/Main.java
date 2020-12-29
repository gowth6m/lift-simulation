package liftsimulation;


import liftsimulation.UI.Simulation;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Simulation simulation = new Simulation();
                simulation.setVisible(true);

                simulation.addFloors(10);
            }
        });
    }
}
