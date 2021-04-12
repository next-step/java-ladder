package ladder.domain;

public class Position {
    public static final Position FIRST = Position.of("FIRST");
    public static final Position BODY = Position.of("BODY");
    public static final Position LAST = Position.of("LAST");
    public static final Position DEFAULT = Position.of("");

    private final String position;

    private Position(String position) {
        this.position = position;
    }

    public static Position of(String position) {
        return new Position(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position='" + position + '\'' +
                '}';
    }
}
