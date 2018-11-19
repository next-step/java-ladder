import java.util.ArrayList;
import java.util.List;

public class Line {
    private final int BEFORE_COUNT = 1;
    private final Boolean LINEAR = true;
    private final Boolean BLANK = false;
    private List<Point> points = new ArrayList<>();
    private int count;

    public Line(int countOfPerson) {
        this.count = countOfPerson;

    }
    public void initLine(){
        for (int i = 0; i < count - BEFORE_COUNT; i++) {
            points.add(calculatePoint(i));
        }
    }

    public Point calculatePoint(int count) {
        if (count == 0) {
            return new PointGenerator().getRandomBoolean();
        }
        //이전이 직선인지 아닌지 확인!
        if (validationCheck(points)){
            return Point.of(BLANK);
        }
        return new PointGenerator().getRandomBoolean();

    }

    public Boolean validationCheck(List<Point> points) {
        return points.get(points.size() - BEFORE_COUNT).equals(Point.of(LINEAR));
    }

    @Override
    public String toString() {
        StringBuilder lineString = new StringBuilder();
        lineString.append("  |  ");
        points.stream().forEach(point -> lineString.append(point.toString()));
        return lineString.toString();
    }
}



