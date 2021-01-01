package liftsimulation;

import java.util.ArrayList;

public class Building {
    private int maxFloor;
    private int minFloor;
    private LiftAlgorithm liftAlgo;
    // TODO change this part new Lift()
    private Lift lift = new Lift();
    private ArrayList<Floor> listOfFloors = new ArrayList<>();
    private ArrayList<Human> waitingToBePicked;
    private ArrayList<Human> alreadyPicked;

    public Building(int maxFloor) {
        this.maxFloor = maxFloor;
        for (int i = 0; i <= maxFloor; i++) {
            listOfFloors.add(new Floor(this, lift, i));
        }
    }

    public ArrayList<Floor> getListOfFloors() {
        return listOfFloors;
    }

}
