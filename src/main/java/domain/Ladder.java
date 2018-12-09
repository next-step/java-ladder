package domain;

import util.DirectionGenerator;

public class Ladder {

    private final Lines lines;

    public Ladder(final Players players, final int height, final DirectionGenerator generator) {
        lines = new Lines(players, height, generator);
    }

    public int move(final int position) {
        return lines.move(position);
    }

    @Override
    public String toString() {
        return lines.toString();
    }

}
