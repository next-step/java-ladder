package nextstep.laddergame.domain;

import java.util.Objects;
import java.util.Optional;

public class Ladder {
    private static final Integer INIT_POSITION = 0;
    private final Integer position;
    private final Lines lines;

    public Ladder(Integer position, Lines lines) {
        this.position = position;
        this.lines = lines;
    }

    public static Ladder create(Optional<Ladder> beforeLadder, int maxHeight, LadderLinesGenerator ladderLinesGenerator) {
        return new Ladder(
                beforeLadder.map(Ladder::nextPosition).orElse(INIT_POSITION),
                ladderLinesGenerator.generate(beforeLadder, maxHeight)
        );
    }

    public static Ladder createLastLadder(int laddersSize, int height) {
        return new Ladder(laddersSize - 1, Lines.empty(height));
    }

    private Integer nextPosition() {
        return this.position + 1;
    }

    public boolean isLineAlreadySetAt(int floor) {
        return lines.isAlreadySetAt(floor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(position, ladder.position) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, lines);
    }
}
