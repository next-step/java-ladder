/*
 * Line의 각 세로 지점을 의미하며, 연결되어있는 포인트를 보유하고 있는 클래스
 * */
package laddergame.domain.ladder;

public class Point {
    private Point linkPoint;

    public Point() {
        this.linkPoint = this;
    }

    public void link(Point point) {
        linkPoint = point;
    }

    public boolean isLinked() {
        return linkPoint != this;
    }

    public boolean isLinkedWith(Point check) {
        return linkPoint == check;
    }
}
