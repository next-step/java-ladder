package ladder.domain.ladder;

public enum HorizontalLineDirection {

    LEFT(-1), RIGHT(1), NONE(0);

    private final int value;

    HorizontalLineDirection(int value) {
        this.value = value;
    }
}
