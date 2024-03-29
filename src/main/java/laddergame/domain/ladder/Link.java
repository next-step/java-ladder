package laddergame.domain.ladder;

public enum Link {
    LINKED(true),
    UNLINKED(false);

    private final boolean value;

    Link(boolean value) {
        this.value = value;
    }

    public boolean isLinked() {
        return this == LINKED;
    }

    public boolean isUnLinked() {
        return this == UNLINKED;
    }

    public boolean value() {
        return value;
    }
}
