package ladder.domain;

import java.util.ArrayList;
import java.util.List;

class LineMaker {
    private static final int NUMBER_OF_FIRST_AND_LAST_BAR = 2;

    private List<Bar> randomBars;
    private RandomBarGenerator barGenerator = new RandomBarGenerator();

    List<Bar> generateBars(int numberOfPlayers) {
        this.randomBars = new ArrayList<>();
        generateFirstBar();
        generateMiddleBars(numberOfPlayers);
        generateEmptyBar();
        return randomBars;
    }

    private void generateFirstBar() {
        randomBars.add(Bar.from(barGenerator.generateBar()));
    }

    private void generateMiddleBars(int numberOfPlayers) {
        int spaceForMiddleBars = numberOfPlayers - NUMBER_OF_FIRST_AND_LAST_BAR;
        for (int i = 0; i < spaceForMiddleBars; i++) {
            Bar previousBar = randomBars.get(i);
            addNextBar(previousBar);
        }
    }

    private void addNextBar(Bar previousBar) {
        if (previousBar.isExist()) {
            generateEmptyBar();
            return;
        }
        randomBars.add(Bar.from(barGenerator.generateBar()));
    }

    private void generateEmptyBar() {
        randomBars.add(Bar.from(Boolean.FALSE));
    }
}
