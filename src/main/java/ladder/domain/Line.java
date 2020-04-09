package ladder.domain;

import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.RandomLineGenerator;

import java.util.Collections;
import java.util.List;

public class Line {
    private final Stairs stairs;

    private Line(final List<Stair> stairs) {
        this.stairs = new Stairs(stairs);
    }

    public static Line of(final int playerCount) {
        return new Line(new RandomLineGenerator().generate(playerCount));
    }

    public static Line of(final int playerCount, final LineGenerator lineGenerator) {
        return new Line(lineGenerator.generate(playerCount));
    }

    public Position move(final Position position) {
        return stairs.move(position);
    }

    public List<Stair> getLine() {
        return Collections.unmodifiableList(stairs.getStairs());
    }
}