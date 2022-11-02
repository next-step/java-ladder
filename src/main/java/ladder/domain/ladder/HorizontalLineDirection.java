package ladder.domain.ladder;

public enum HorizontalLineDirection {

    LEFT, RIGHT, NONE;

    public boolean isRight() {
        return this == HorizontalLineDirection.RIGHT;
    }
}
