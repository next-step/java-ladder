package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final Floors floors;
    private final LadderResult ladderResult;

    public Ladder(Floors floors, LadderResult ladderResult) {
        this.floors = floors;
        this.ladderResult = ladderResult;
    }

    public List<Floor> getFloors() {
        return floors.getFloors();
    }

    public String finalResult(Position position) {
        Position finalPosition = floors.finalPosition(position);
        return ladderResult.result(finalPosition);
    }

    public List<String> finalResultsOfAll(int numberOfParticipants) {
        List<String> results = new ArrayList<>();
        IntStream.range(0, numberOfParticipants)
                .forEach(i -> results.add(finalResult(new Position(i))));

        return results;
    }
}
