/*
 * 두 포인트간의 연결을 관리하는 클래스
 * */
package laddergame.domain.ladder.line;

public class Link<T> {
    private T now;
    private T next;

    /* 두 Point를 가지는 한쌍을 생성한다. */
    public void pair(T newPair) {
        switchPair(newPair);
        next(newPair);
        now(newPair);
    }

    /* 현재 포인트가 비어있다면 now에 넣는다. */
    private void now(T newPair) {
        if (!hasNow()) {
            this.now = newPair;
        }
    }

    /* 다음 포인트만 비어있다면 next에 넣는다. */
    private void next(T newPair) {
        if (hasNow() && !hasNext()) {
            this.next = newPair;
        }
    }

    /* 두 포인트가 넣어져있다면 다음을 현재로, 그리고 새로운 포인트를 다음에 넣는다. */
    private void switchPair(T newPair) {
        if (haveAll()) {
            this.now = this.next;
            this.next = newPair;
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

    public boolean isNow(T check) {
        return now == check;
    }

    public boolean isNext(T check) {
        return next == check;
    }

    public T getNow() { return now; }
    public T getNext() { return next; }
}
