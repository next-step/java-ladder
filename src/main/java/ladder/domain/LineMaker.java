package ladder.domain;

import java.util.ArrayList;
import java.util.List;

class LineMaker {

    private List<Bar> randomBars = new ArrayList<>();
    private RandomBarGenerator barGenerator = new RandomBarGenerator();

    List<Bar> generateBars(int numberOfPlayers) {
        generateFirstBar();
        generateMiddleBars(numberOfPlayers);
        generateLastBar();
        return randomBars;
    }

    private void generateFirstBar() {
        randomBars.add(Bar.from(barGenerator.generateBar()));
    }

    private void generateMiddleBars(int numberOfPlayers) {
        int spaceForMiddleBars = numberOfPlayers - 1;
        for (int i = 1; i < spaceForMiddleBars; i++) {
            Bar previousBar = randomBars.get(i - 1);
            addNextBar(previousBar);
        }
    }

    private void addNextBar(Bar previousBar) {
        if (previousBar.isExist()) {
            generateLastBar();
            return;
        }
        randomBars.add(Bar.from(barGenerator.generateBar()));
    }

    private void generateLastBar() {
        randomBars.add(Bar.from(Boolean.FALSE));
    }
}
