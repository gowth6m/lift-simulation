package liftsimulation;

import java.util.ArrayList;

public class Floor {
    private int floorNumber;
    private Lift lift;
    private ArrayList<Human> listOfPeople;
    private boolean isLiftOnFloor;

    public Floor(Lift lift, int floorNumber) {
        this.lift = lift;
        this.floorNumber = floorNumber;
    }

    public void addToFloor(Human human) {
        listOfPeople.add(human);
    }

    public void getOnLift(Human human) {

    }

    // Getter/Setter
    public boolean getIsLiftOnFloor() {
        return isLiftOnFloor;
    }
    
    public void setIsLiftOnFloor(boolean b) {
        this.isLiftOnFloor = b;
    }
}
