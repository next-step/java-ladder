package nextstep.ladder.entity.ladder;

import java.util.Objects;

/**
 * 사다리의 각 지점을 추상화
 * 가로 방향으로 연결되어 Link를 통해 연결되었는지를 나타냄 
 */
public class Point {

    private Point next;
    private Point linkWith;

    public void next(Point next) {
        this.next = next;
    }

    public boolean isLinked() {
        return Objects.nonNull(linkWith);
    }

    public boolean hasNext() {
        return Objects.nonNull(next);
    }

    public boolean hasBackwardLink() {
        return Objects.nonNull(linkWith) && !Objects.equals(next, linkWith);
    }

    public void linkWithNext() {
        if (hasNext()) {
            this.linkWith = next;
            next.linkWith = this;
        }
    }

    public Point getNext() {
        return this.next;
    }

}
