package nextstep.ladder.domain.floor;

public enum Link {
    LINKED,
    UNLINKED;

    public static Link of(boolean linked) {
        if (linked) {
            return LINKED;
        }
        return UNLINKED;
    }
}
