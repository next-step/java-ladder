package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Ladders {
    private final List<Ladder> ladders;

    public Ladders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public static Ladders create(int participantsSize, int maxHeight, LadderLinesGenerator ladderLinesGenerator) {
        ArrayList<Ladder> newLadders = new ArrayList<>();
        Ladder beforeLadder = null;

        for (int i = 0; i < participantsSize - 1; i++) {
            Ladder ladder = Ladder.create(Optional.ofNullable(beforeLadder), maxHeight, ladderLinesGenerator);
            newLadders.add(ladder);
            beforeLadder = ladder;
        }

        newLadders.add(Ladder.createLastLadder(participantsSize, maxHeight));
        return new Ladders(newLadders);
    }

    public int size() {
        return ladders.size();
    }

    public Ladder ladderAt(int line) {
        return this.ladders.get(line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladders ladders1 = (Ladders) o;
        return Objects.equals(ladders, ladders1.ladders);  // false.
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladders);
    }
}
