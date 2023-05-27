package ladder.domain.moving;

public enum Moving {
    LEFT(Displacement.LEFT, Type.LEFT),
    RIGHT(Displacement.RIGHT, Type.RIGHT),
    FORWARD(Displacement.FORWARD, Type.FORWARD),
    STOP(Displacement.STOP, Type.STOP);

    private final Displacement displacement;
    private final Type type;

    Moving(Displacement displacement, Type type) {
        this.displacement = displacement;
        this.type = type;
    }

    public Displacement displacement() {
        return displacement;
    }

    public Type type() {
        return type;
    }

}
