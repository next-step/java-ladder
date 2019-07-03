package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> bars;

    public Line(List<Boolean> bars) {
        this.bars = new ArrayList<>(bars);
    }

    public static Line from(int numberOfPlayers) {
        Random random = new Random();
        List<Boolean> randomBars = new ArrayList<>();

        randomBars.add(random.nextBoolean());
        for (int i = 1; i < numberOfPlayers - 1; i++) {
            boolean previousBarExist = randomBars.get(i - 1);
            if (previousBarExist) {
                randomBars.add(false);
            }else {
                randomBars.add(random.nextBoolean());
            }
        }
        return new Line(randomBars);
    }

    public List<Boolean> getBars() {
        return Collections.unmodifiableList(bars);
    }
}
