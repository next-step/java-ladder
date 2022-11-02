package ladder.domain.ladder.direction;

public enum HorizontalLineDirection {

    LEFT, RIGHT, NONE;

    public boolean isRight() {
        return this == HorizontalLineDirection.RIGHT;
    }
}
