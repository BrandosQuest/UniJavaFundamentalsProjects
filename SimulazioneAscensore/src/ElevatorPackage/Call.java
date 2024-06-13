package ElevatorPackage;

import java.io.Serializable;

public class Call implements Serializable {
    private final int originFloor;
    private final int destinationFloor;
    private Direction direction;

    public Call(int originFloor, int destinationFloor, Building building) {
        if(!(originFloor>=building.getLowestFloor() && originFloor<=building.getHighestFloor())){
            throw new IllegalArgumentException("Origin floor is out of bounds in respect to the building floors numbers");
        }
        if(!(destinationFloor>=building.getLowestFloor() && destinationFloor<=building.getHighestFloor())){
            throw new IllegalArgumentException("Destination floor is out of bounds in respect to the building floors numbers");
        }
        this.originFloor = originFloor;
        this.destinationFloor = destinationFloor;
        determineDirection();
    }
    private void determineDirection() {
        if(destinationFloor>originFloor) {
            direction=Direction.UP;
        }else if(destinationFloor<originFloor) {
            direction=Direction.DOWN;
        }else {
            throw new IllegalArgumentException("Origin floor is the same as the destination floor");
        }
    }

    @Override
    public String toString() {
        return "\nCall{" +
                "originFloor=" + originFloor +
                ", destinationFloor=" + destinationFloor +
                ", direction=" + direction +
                '}';
    }
}