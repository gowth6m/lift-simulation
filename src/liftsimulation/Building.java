package liftsimulation;

import java.util.ArrayList;

public class Building {
    private int maxFloor;
    private int minFloor;
    private LiftAlgorithm lift;
    private ArrayList<Floor> listOfFloors;
    private ArrayList<Human> waitingToBePicked;
    private ArrayList<Human> alreadyPicked;

    public Building(int maxFloor) {
        this.maxFloor = maxFloor;
    }
}
