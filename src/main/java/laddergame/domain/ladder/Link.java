/*
 * 두 포인트간의 연결을 관리하는 클래스
 * */
package laddergame.domain.ladder;

public class Link<P, N> {
    private P now;
    private N next;

    /* 두 Point를 가지는 한쌍을 생성한다. */
    public void pair(P newPair) {
        switchPair(newPair);
        next(newPair);
        now(newPair);
    }

    /* 현재 포인트가 비어있다면 now에 넣는다. */
    private void now(P newPair) {
        if (!hasNow()) {
            this.now = newPair;
        }
    }

    /* 다음 포인트만 비어있다면 next에 넣는다. */
    private void next(P newPair) {
        if (hasNow() && !hasNext()) {
            this.next = (N) newPair;
        }
    }

    /* 두 포인트가 넣어져있다면 다음을 현재로, 그리고 새로운 포인트를 다음에 넣는다. */
    private void switchPair(P newPair) {
        if (haveAll()) {
            this.now = (P) this.next;
            this.next = (N) newPair;
        }
    }

    /* 전략에 따라서 한 쌍을 연결한다. */
    public void link(LadderStrategy strategy) {
        if (!haveAll() || !(now instanceof Point) || !(next instanceof Point)) {
            return;
        }
        if (strategy.test() && !((Point) now).isLinked()) {
            ((Point) now).link((Point) next);
            ((Point) next).link((Point) now);
        }
    }

    public boolean hasNow() {
        return now != null;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean haveAll() {
        return hasNow() && hasNext();
    }

    public boolean isNow(P now) {
        return hasNow() && this.now == now;
    }

    public boolean isNext(N next) {
        return hasNext() && this.next == next;
    }

}
