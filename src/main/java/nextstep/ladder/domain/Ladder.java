package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MINIMUM_RAIL_COUNT = 2;

    private final List<Rail> rails;

    private Ladder(List<Rail> rails) {
        this.rails = Collections.unmodifiableList(rails);
    }


    public static Ladder of(int numberOfPlayer, Height height) {
        if (numberOfPlayer < MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("invalid number of player: must be larger than 2, but " + numberOfPlayer);
        }

        List<Rail> rails = new ArrayList<>(numberOfPlayer);

        for (int i = 0; i < numberOfPlayer; i++) {
            rails.add(Rail.of(height));
        }

        return new Ladder(rails);
    }

    public static Ladder of(int numberOfPlayer, int height) {
        return Ladder.of(numberOfPlayer, Height.of(height));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(rails, ladder.rails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rails);
    }
}
