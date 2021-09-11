package step2.domain;

public class Ladder {
    private final String name;
    private final Line line;

    public Ladder(String name, int height) {
        this.name = name;
        this.line = new Line(height);
    }

    public Ladder(String name, Ladder previousLadder) {
        this.name = name;
        this.line = new Line(previousLadder.line);
    }

    @Override
    public String toString() {
        return String.format("%5s\n", name)
                + line;
    }
}
