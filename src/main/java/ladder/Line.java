package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> bars;

    private Line(List<Boolean> bars) {
        this.bars = new ArrayList<>(bars);
    }

    public static Line from(int numberOfPlayers) {
        return new Line(generateBars(numberOfPlayers));
    }

    private static List<Boolean> generateBars(int numberOfPlayers) {
        Random random = new Random();
        List<Boolean> randomBars = new ArrayList<>();

        randomBars.add(random.nextBoolean());
        for (int i = 1; i < numberOfPlayers - 1; i++) {
            boolean previousBarExist = randomBars.get(i - 1);
            addNextBar(random, randomBars, previousBarExist);
        }
        return randomBars;
    }

    private static void addNextBar(Random random, List<Boolean> randomBars, boolean previousBarExist) {
        if (previousBarExist) {
            randomBars.add(false);
            return;
        }
        randomBars.add(random.nextBoolean());
    }

    public List<Boolean> getBars() {
        return Collections.unmodifiableList(bars);
    }
}
