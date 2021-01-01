package liftsimulation;

import java.util.ArrayList;

public class Building {
    private int maxFloor;
    private int minFloor;
    private LiftAlgorithm liftAlgo;
    private Lift lift;
    private ArrayList<Floor> listOfFloors;
    private ArrayList<Human> waitingToBePicked;
    private ArrayList<Human> alreadyPicked;

    public Building(int maxFloor) {
        this.maxFloor = maxFloor;
        for(int i = 0; i < maxFloor; i++) {
            listOfFloors.add(new Floor(lift, i));
        }
    }

}
