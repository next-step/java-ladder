/*
 * Line의 각 세로 지점을 의미하며, 연결되어있는 포인트를 보유하고 있는 클래스
 *
 * @Ver 2.0
 * 이전과 달라진 점은 연결된 Point의 정보를 가지고있었던 전과는 달리
 * 반드시 순서가 보장된다는 가정하에 Before, Next로만 연결
 * 그러므로 연결줄 생성은 Before-Next가 순서대로 들어왔을때만 가능하다. (Next-Before은 불가능)
 * */
package laddergame.domain.ladder.line;

import java.util.Objects;

public class Point {
    private LinkStatus linkStatus;

    public Point() {
        this.linkStatus = LinkStatus.NOT_LINK;
    }

    public void link(Point point) {
        this.linkStatus = LinkStatus.LINK_BEFORE;
        point.linkStatus = LinkStatus.LINK_NEXT;
    }

    public boolean isLinked() {
        return linkStatus.isLinked();
    }

    public boolean isLinkedWith(Point check) {
        return isLinked() && linkStatus.isLinkedWith(check.linkStatus);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return linkStatus == point.linkStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkStatus);
    }
}
