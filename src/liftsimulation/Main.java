package liftsimulation;


import liftsimulation.UI.Simulation;

import javax.swing.*;

public class Main {
    private static int startNoOfFloors = 10;
    private static int startNoOfPeopleInBuilding = 0;

    public void startSimulation() {
        Building building = new Building(startNoOfFloors);
    }

    public static void main(String[] args) {
        System.out.println("main function: " + Thread.currentThread().getName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("GUI function: " + Thread.currentThread().getName());
                Simulation simulation = new Simulation();
                simulation.setVisible(true);
                simulation.addFloors(startNoOfFloors);
            }
        });
    }
}
