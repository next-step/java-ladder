package ladder.domain;

import java.util.ArrayList;
import java.util.List;

class LineMaker {

    private List<Bar> randomBars = new ArrayList<>();
    private RandomBarGenerator barGenerator = new RandomBarGenerator();

    List<Bar> generateBars(int numberOfPlayers) {
        randomBars.add(Bar.from(barGenerator.generateBar()));
        for (int i = 1; i < numberOfPlayers - 1; i++) {
            Bar previousBar = randomBars.get(i - 1);
            addNextBar(previousBar);
        }
        addBlankBar();
        return randomBars;
    }

    private void addNextBar(Bar previousBar) {
        if (previousBar.isExist()) {
            addBlankBar();
            return;
        }
        randomBars.add(Bar.from(barGenerator.generateBar()));
    }

    private void addBlankBar() {
        randomBars.add(Bar.from(Boolean.FALSE));
    }
}
