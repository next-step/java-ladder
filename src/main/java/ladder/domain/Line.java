package ladder.domain;

import lombok.ToString;

import java.util.List;

import static ladder.domain.PointGenerator.generate;

@ToString
public class Line {
    public static final int MIN_PLAYERS = 2;
    public static final int POINT_MAINTAINER = 1;
    private List<Point> points;

    public Line (int countOfPerson, LEVEL level) {
        validate(countOfPerson);
        points = initPoints(countOfPerson, level);
    }

    protected Line (List<Point> points) {
        validate(points.size());
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int movePoint(int index) {
        int moveResult = points.get(index).move();
        if(points.size() == moveResult) {
            return moveResult - POINT_MAINTAINER;
        }
        return moveResult;
    }

    private List<Point> initPoints(int countOfPerson, LEVEL level) {
        return generate(countOfPerson, level);
    }

    private void validate(int countOfPerson) {
        if(countOfPerson < MIN_PLAYERS) {
            throw new IllegalArgumentException("혼자서 어떻게 게임을 해 ...ㅠㅠ");
        }
    }
}