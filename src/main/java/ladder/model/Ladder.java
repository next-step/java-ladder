package ladder.model;

public enum Ladder {

    LINE_WITH_POINTS("-----|"),
    LINE_ONLY("     |");

    private final String shape;

    Ladder(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return this.shape;
    }
}
