package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Floors {
    private final List<Floor> floors;

    public Floors(List<Floor> floors) {
        this.floors = floors;
    }

    public int size() {
        return floors.size();
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<Position> finalPositions(int numberOfParticipants) {
        List<Position> positions = new ArrayList<>();
        IntStream.range(0, numberOfParticipants)
                .forEach(i -> positions.add(finalPosition(new Position(i))));

        return positions;
    }

    private Position finalPosition(Position position) {
        Position current = position;
        for (Floor floor : floors) {
            current = floor.move(current);
        }

        return current;
    }
}
