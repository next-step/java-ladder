package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Positions {
    private final List<Integer> positions;

    private Positions(Participant participant, Ladder ladder) {
        this.positions = toPositions(participant, ladder);
    }

    private Positions(List<Integer> positions) {
        this.positions = positions;
    }

    public static Positions of(Participant participant, Ladder ladder) {
        return new Positions(participant, ladder);
    }

    public static Positions of(List<Integer> positions) {
        return new Positions(positions);
    }

    private List<Integer> toPositions(Participant participant, Ladder ladder) {
        List<Integer> finalPositions = new ArrayList<>();

        for (int i = 0; i < participant.size(); i++) {
            finalPositions.add(ladder.move(i));
        }
        return finalPositions;
    }

    public Results makeFinalResults(List<String> initResults) {
        return Results.of(positions.stream()
                .map(position -> initResults.get(position))
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
