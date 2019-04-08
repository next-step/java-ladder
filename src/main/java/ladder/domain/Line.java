package ladder.domain;

import lombok.ToString;

import java.util.List;

@ToString
public class Line {

    public static final int MIN_PLAYERS = 2;
    private List<Point> points;
    private PointGenerator pointGenerator = new PointGenerator();

    public Line (int countOfPerson) {
        validation(countOfPerson);
        points = initPoints(countOfPerson);
    }

    List<Point> initPoints(int countOfPerson) {
        return pointGenerator.generate(countOfPerson);
    }

    private void validation(int countOfPerson) {
        if(countOfPerson < MIN_PLAYERS) {
            throw new IllegalArgumentException("혼자서 어떻게 게임을 해 ...ㅠㅠ");
        }
    }

    public List<Point> points() {
        return points;
    }
}