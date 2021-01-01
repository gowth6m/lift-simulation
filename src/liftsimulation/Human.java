package liftsimulation;

public class Human {
    private Floor currentFloor;
    private Floor targetFloor;
    private int timeSpentInLift;

    /**
     * Constructor
     */
    public Human(Floor currentFloor, Floor targetFloor) {
        this.currentFloor = currentFloor;
        this.targetFloor = targetFloor;
    }

    public int calculateTimeSpentInLift() {
        int time = 0;
        return time;
    }

    // Getter/Setters
    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setTargetFloor(Floor targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getTimeSpentInLift() {
        return calculateTimeSpentInLift();
    }
}
