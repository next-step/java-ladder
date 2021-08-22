package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Positions {
    private final List<Integer> positions;

    public static Positions of(List<Integer> positions) {
        return new Positions(positions);
    }

    public static Positions of(Participant participant, Ladder ladder) {
        return toFinalPositions(participant, ladder);
    }

    private static Positions toFinalPositions(Participant participant, Ladder ladder) {
        List<Integer> finalPositions = new ArrayList<>();

        for (int i = 0; i < participant.size(); i++) {
            finalPositions.add(ladder.movedPosition(i));
        }

        return new Positions(finalPositions);
    }

    private Positions(List<Integer> positions) {
        this.positions = positions;
    }


    public Results makeFinalResults(List<String> initResults) {
        return Results.of(positions.stream()
                .map(initResults::get)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positions positions1 = (Positions) o;
        return Objects.equals(positions, positions1.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
