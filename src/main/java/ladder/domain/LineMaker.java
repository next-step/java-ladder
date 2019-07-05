package ladder.domain;

import java.util.ArrayList;
import java.util.List;

class LineMaker {

    private List<Boolean> randomBars = new ArrayList<>();
    private RandomBarGenerator barGenerator = new RandomBarGenerator();

    List<Boolean> generateBars(int numberOfPlayers) {
        randomBars.add(barGenerator.generateBar());
        for (int i = 1; i < numberOfPlayers - 1; i++) {
            boolean previousBarExist = randomBars.get(i - 1);
            addNextBar(previousBarExist);
        }
        addBlankBar();
        return randomBars;
    }

    private void addNextBar(boolean previousBarExist) {
        if (previousBarExist) {
            addBlankBar();
            return;
        }
        randomBars.add(barGenerator.generateBar());
    }

    private void addBlankBar() {
        randomBars.add(false);
    }
}
