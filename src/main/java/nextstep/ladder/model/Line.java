package nextstep.ladder.model;

import java.util.*;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private Random random = new Random();

    public Line(int countOfPerson) {
        for (int i = 1; i < countOfPerson; i++) {
            points.add(isPreLine(i));
        }
    }

    public boolean isPreLine(int point) {
        if(points.isEmpty()){
            points.add(random.nextBoolean());
        }
        return points.get(point - 1) ? false : random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

}