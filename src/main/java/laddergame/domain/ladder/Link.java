package laddergame.domain.ladder;

import java.util.function.Predicate;

public enum Link {
    LEFT(-1, Link::isLinkedRight),
    RIGHT(1, Link::isUnLinked),
    DOWN(0, beforeLink -> beforeLink.isUnLinked() || beforeLink.isLinkedLeft());

    private final int value;
    private final Predicate<Link> beforeLinkCondition;

    Link(int value, Predicate<Link> beforeLinkCondition) {
        this.value = value;
        this.beforeLinkCondition = beforeLinkCondition;
    }

    public boolean isLinked() {
        return this == LEFT || this == RIGHT;
    }

    public boolean isLinkedRight() {
        return this == RIGHT;
    }

    public boolean isLinkedLeft() {
        return this == LEFT;
    }

    public boolean isUnLinked() {
        return this == DOWN;
    }

    public int value() {
        return value;
    }

    public boolean isValidBeforeLink(Link beforeLink) {
        return beforeLinkCondition.test(beforeLink);
    }
}
