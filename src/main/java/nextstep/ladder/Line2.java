package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line2 {
    private static final Random RANDOM = new Random();

    private List<Cross> crosses;

    public Line2(int countOfPerson) {
        createCrosses(countOfPerson);
    }

    private void createCrosses(int countOfPerson) {
        crosses = new ArrayList<Cross>();

        Point point = Point.first(RANDOM.nextBoolean());
        for (int i = 0; i < countOfPerson; i++) {
            crosses.add(new Cross(i, i == 0 ? point : i == countOfPerson - 1 ? point.last() : point.next(RANDOM.nextBoolean())));
        }
    }

    public int move(int position) {
        return this.crosses.get(position).move();
    }

}
