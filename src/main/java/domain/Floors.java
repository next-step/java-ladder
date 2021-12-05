package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Floors {
    private static final int START_POINT_FOR_CONSTRUCTING_FLOORS = 0;

    private final List<Floor> floors;

    public Floors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Position finalPosition(Position position) {
        Position current = position;
        for (Floor floor : floors) {
            current = floor.move(current);
        }

        return current;
    }

    public static Floors of(int heightOfLadder, int participantSize) {
        List<Floor> floors = new ArrayList<>();
        IntStream.range(START_POINT_FOR_CONSTRUCTING_FLOORS, heightOfLadder)
                .forEach(i -> {
                    floors.add(Floor.of(participantSize));
                });

        return new Floors(floors);
    }
}
