package ladder;

import java.util.ArrayList;
import java.util.List;

class LineMaker {

    private List<Boolean> randomBars = new ArrayList<>();
    private BarGeneratorImpl barGenerator = new BarGeneratorImpl();

    List<Boolean> generateBars(int numberOfPlayers) {
        randomBars.add(barGenerator.generateBar());
        for (int i = 1; i < numberOfPlayers - 1; i++) {
            boolean previousBarExist = randomBars.get(i - 1);
            addNextBar(previousBarExist);
        }
        return randomBars;
    }

    private void addNextBar(boolean previousBarExist) {
        if (previousBarExist) {
            randomBars.add(false);
            return;
        }
        randomBars.add(barGenerator.generateBar());
    }
}
