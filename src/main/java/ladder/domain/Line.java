package ladder.domain;

import ladder.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * 세로줄과 바로옆 세로줄 사이의 작은 가로줄이 아니라
 * 쭉이어진 가로줄 전체를 뜻함
 */
public class Line {
    private List<Point> points;

    public Line(int playerCount, Drawable drawable) {
        init(playerCount);
        draw(playerCount, drawable);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    // 왼쪽부터 오른쪽으로 그려나간다
    // 맨 마지막점은 체크할 필요 없다.
    private void draw(int playerCount, Drawable drawable) {
        for (int i = 0; i < playerCount - 1; i++) {
            connectPoint(i, drawable);
        }
    }

    private void connectPoint(int index, Drawable drawable) {
        if (!isPreviousPointRightDirection(index) && drawable.canDraw()) {
            points.get(index).changeDirection(Direction.RIGHT);
            points.get(index + 1).changeDirection(Direction.LEFT);
        }
    }

    // 왼쪽점의 방향이 오른쪽인지 체크한다.
    private boolean isPreviousPointRightDirection(int index) {
        return this.points.stream()
                .anyMatch(point -> point.isEqualIndex(index - 1) && point.isDirection(Direction.RIGHT));
    }

    private void init(int playerCount) {
        this.points = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            this.points.add(new Point(i, Direction.NONE));
        }
    }
}
