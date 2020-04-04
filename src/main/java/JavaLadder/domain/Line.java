package JavaLadder.domain;

import java.util.*;

public class Line {
    private List points = new ArrayList<>();


    public Line(int countOfPerson) {
        List points = generate(countOfPerson);
        this.points = points;
    }

    private List generate(int countOfPerson) {
        List<Boolean> points = new ArrayList();
        for (int i = 0; i < countOfPerson - 1; i++) {
            checkSuccessTrue(points, i);
        }
        return points;
    }

    private void checkSuccessTrue(List<Boolean> points, int i) {
        if (i > 0 && points.get(i - 1)) {
            points.add(false);
            return;
        }
        points.add(new Random().nextBoolean());
        return;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }


}
