package ladder.domain;

import java.util.List;

// 사다리의 가로 선
public class Line {
    public static final int MIN_PLAYER_COUNT = 2;
    private Points points;

    public Line(Points points) {
        this.points = points;
    }

    public Line(int countOfPlayer) {
        if(countOfPlayer < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자는 최소 2명 이상이어야 합니다.");
        }
        this.points = new Points(countOfPlayer);
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }

    public Boolean getPoint(int index) {
        return points.getPoint(index).exist();
    }
}
