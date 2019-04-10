package ladder.domain;

import lombok.ToString;

import java.util.List;

@ToString
public class Line implements PointGenerator {

    public static final int MIN_PLAYERS = 2;
    private List<Point> points;

    public Line (int countOfPerson) {
        validate(countOfPerson);
        points = initPoints(countOfPerson);
    }

    protected List<Point> initPoints(int countOfPerson) {
        return generate(countOfPerson);
    }

    private void validate(int countOfPerson) {
        if(countOfPerson < MIN_PLAYERS) {
            throw new IllegalArgumentException("혼자서 어떻게 게임을 해 ...ㅠㅠ");
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public int movePoint(int index) {
        int moveResult = points.get(index).move(index);
        if(points.size() == moveResult) {
            return moveResult - 1;
        }
        return moveResult;
    }
}