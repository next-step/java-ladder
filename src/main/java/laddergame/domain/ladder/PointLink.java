package laddergame.domain.ladder;

import static laddergame.util.Message.ILLEGAL_LINK;

public class PointLink extends Link<Point> {
    /* 전략에 따라서 한 쌍을 연결한다. */
    public void link(LadderStrategy strategy) {
        if (validLink() && strategy.test()) {
            now.link(next);
            next.link(now);
        }
    }

    public boolean isLink() {
        validLink();
        if (now.isLinkedWith(next) &&
                next.isLinkedWith(now)) {
            return true;
        }
        return false;
    }

    private boolean validLink() {
        if (!haveAll()) {
            throw new IllegalArgumentException(ILLEGAL_LINK);
        }
        if (now.isLinked() || now == next) {
            return false;
        }
        return true;
    }
}
