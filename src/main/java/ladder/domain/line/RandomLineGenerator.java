package ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator {

    private static final Random random = new Random();

    private RandomLineGenerator() {

    }

    public static Line getLine(int countOfPerson) {
        return new Line(countOfPerson, initBars(countOfPerson));
    }

    private static List<Bar> initBars(int countOfPerson) {
        List<Bar> bars = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            bars.add(initBar(i, bars));
        }
        return bars;
    }

    private static Bar initBar(int index, List<Bar> bars) {
        if (index == 0 || bars.get(index - 1).isAvailable()) {
            return new Bar(false);
        }
        return new Bar(random.nextBoolean());
    }

}
