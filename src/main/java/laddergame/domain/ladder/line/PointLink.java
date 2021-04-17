/*
 * Point 한쌍의 Link를 관리하는 클래스
 * */
package laddergame.domain.ladder.line;

import laddergame.domain.ladder.LadderStrategy;

public class PointLink {
    private Link<Point> links = new Link<>();

    public void pair(Point point) {
        this.links.pair(point);
    }

    /* 전략에 따라서 한 쌍을 연결한다. */
    public void link(LadderStrategy strategy) {
        if (canLink() && strategy.test()) {
            links.getNow().link(links.getNext());
        }
    }

    public boolean isLink() {
        if (validLink() && links.getNow().isLinkedWith(links.getNext())) {
            return true;
        }
        return false;
    }

    private boolean canLink() {
        if (validLink() && !links.getNow().isLinked()) {
            return true;
        }
        return false;
    }

    private boolean validLink() {
        if (links.haveAll()) {
            return true;
        }
        return false;
    }

    public boolean isNow(Point point) {
        return links.isNow(point);
    }

    public boolean isNext(Point point) {
        return links.isNext(point);
    }
}
