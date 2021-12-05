package domain;

import java.util.List;

import static domain.RandomGenerator.produceRandomFlags;

public class Floor {
    private static final int DECREMENT_FOR_STAIRS_PER_FLOOR = 1;

    private final List<Boolean> states;

    public Floor(List<Boolean> states) {
        this.states = states;
    }

    public List<Boolean> getStates() {
        return states;
    }

    public Position move(Position position) {
        if (position.isMovableLeft(states)) {
            return position.moveLeft();
        }

        if (position.isMovableRight(states)) {
            return position.moveRight();
        }

        return position;
    }

    public static Floor of(int participantSize) {
        int numberOfStairsPerFloor = participantSize - DECREMENT_FOR_STAIRS_PER_FLOOR;
        List<Boolean> randomFlags = produceRandomFlags(numberOfStairsPerFloor);

        return new Floor(randomFlags);
    }
}
