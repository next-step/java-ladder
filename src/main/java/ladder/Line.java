package ladder;

import ladder.util.RandomValueGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(RandomValueGenerator.generate());
        }
    }

    public List<Boolean> getPoints(){
        return points;
    }
}
