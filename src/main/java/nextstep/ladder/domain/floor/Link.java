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

    public Link nextLink(boolean wished) {
        if (this == LINKED) {
            return UNLINKED;
        }
        return of(wished);
    }
}
