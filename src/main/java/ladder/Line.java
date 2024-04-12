package ladder;

import java.util.List;

// 사다리의 가로 선
public class Line {
    private Points points;

    public Line(Points points) {
        this.points = points;
    }

    public Line(int countOfPlayer) {
        if(countOfPlayer <= 1) {
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
