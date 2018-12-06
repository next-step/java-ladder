package domain;

public class Ladder {

    private final Lines lines;

    public Ladder(final Players players, final int height) {
        lines = new Lines(players, height);
    }

    public int move(final int position) {
        return lines.move(position);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(lines.toString());
        return sb.toString();
    }

}
