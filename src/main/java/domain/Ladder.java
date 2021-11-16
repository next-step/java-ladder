package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int START_POINT = 0;
    private static final int DECREMENT_FOR_STAIRS_PER_FLOOR = 1;

    private final int heightOfLadder;
    private final int participantsSize;
    private final Floors floors;

    public Ladder(int heightOfLadder, int participantsSize) {
        this.heightOfLadder = heightOfLadder;
        this.participantsSize = participantsSize;
        this.floors = constituteFloors();
    }

    private Floors constituteFloors() {
        Floors floors = new Floors();
        int numberOfStairsPerFloor = participantsSize - DECREMENT_FOR_STAIRS_PER_FLOOR;
        IntStream.range(START_POINT, heightOfLadder)
                .forEach(i -> {
                    List<Boolean> randomGeneratedFloorStates = RandomGenerator.produceRandomFlags(numberOfStairsPerFloor);
                    floors.produceFloor(randomGeneratedFloorStates);
                });

        return floors;
    }

    public Floors getFloors() {
        return floors;
    }
}
