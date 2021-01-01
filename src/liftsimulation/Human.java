package liftsimulation;

public class Human {
    private int currentFloor;
    private int targetFloor;
    private int timeSpentInLift;

    /**
     * Constructor
     */
    public Human(int currentFloor, int targetFloor) {
        this.currentFloor = currentFloor;
        this.targetFloor = targetFloor;
    }

    public int calculateTimeSpentInLift() {
        int time = 0;
        return time;
    }

    // Getter/Setters
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getTimeSpentInLift() {
        return calculateTimeSpentInLift();
    }
}
