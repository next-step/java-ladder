package domain;

import java.util.stream.IntStream;

public class Ladder {
    private final int START_POINT = 0;

    private final int heightOfLadder;
    private final int participantsSize;
    private final Floors floors;

    public Ladder(int heightOfLadder, int participantsSize) {
        this.heightOfLadder = heightOfLadder;
        this.participantsSize = participantsSize;
        this.floors = constituteFloors();
    }

    private Floors constituteFloors() {
        FloorFactory floorFactory = new FloorFactory(participantsSize);
        Floors floors = new Floors();
        IntStream.range(START_POINT, heightOfLadder)
                .forEach(i -> floors.add(floorFactory.produceFloor()));

        return floors;
    }

    public Floors getFloors() {
        return floors;
    }
}
