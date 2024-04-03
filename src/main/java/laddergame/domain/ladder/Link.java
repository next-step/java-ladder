package laddergame.domain.ladder;

public enum Link {
    LINKED,
    UNLINKED;

    public boolean isLinked() {
        return this == LINKED;
    }

    public boolean isUnLinked() {
        return this == UNLINKED;
    }
}
