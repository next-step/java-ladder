package nextstep.step2.domain;

public class Link {
    private boolean isLinked;

    public Link(boolean isLinked) {
        this.isLinked = isLinked;
    }

    public static Link from(boolean point) {
        return new Link(point);
    }

    public boolean value() {
        return isLinked;
    }
}
