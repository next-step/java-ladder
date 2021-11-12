package domain;

import java.util.List;

public class FloorFactory {
    private final int DECREMENT_FOR_FLOOR = 1;

    private final int numberOfStairs;

    public FloorFactory(int numberOfParticipants) {
        this.numberOfStairs = numberOfParticipants - DECREMENT_FOR_FLOOR;
    }

    public Floor produceFloor() {
        List<Boolean> randomGeneratedFloorStates = RandomGenerator.produceRandomFlags(numberOfStairs);
        return new Floor(randomGeneratedFloorStates);
    }
}
