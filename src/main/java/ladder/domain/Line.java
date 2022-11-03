package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        Random rd = new Random();
        for(int i = 0; i < countOfPerson; i++){
            if(i == 0) {
                points.add(false);
                continue;
            }
            if(points.get(i-1)) {
                points.add(false);
                continue;
            }
            points.add(rd.nextBoolean());
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
