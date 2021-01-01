package liftsimulation;

import java.util.ArrayList;
import java.util.Random;

public class Floor {
    private Building building;
    private int floorNumber;
    private Lift lift;
    private ArrayList<Human> listOfPeople = new ArrayList<>();
    private boolean isLiftOnFloor;

    public Floor(Building building, Lift lift, int floorNumber) {
        this.building = building;
        this.lift = lift;
        this.floorNumber = floorNumber;
        addRandomNoOfPeopleToFloor();
    }

    public void addToFloor(Human human) {
        listOfPeople.add(human);
    }

    public void getOnLift(Human human) {

    }

    public int noOfPeopleOnFloor() {
        return listOfPeople.size();
    }

    public void addRandomNoOfPeopleToFloor() {
        int range = 10;
        int min = 0;
        Random ran = new Random();
        int noOfPeopleOnFloor = ran.nextInt(range) + min;

        for (int i = 0; i < noOfPeopleOnFloor; i++) {
            listOfPeople.add(new Human(this, this));
        }
    }

    // Getter/Setter
    public ArrayList<Human> getListOfPeople() {
        return listOfPeople;
    }

    public boolean getIsLiftOnFloor() {
        return isLiftOnFloor;
    }

    public void setIsLiftOnFloor(boolean b) {
        this.isLiftOnFloor = b;
    }
}
