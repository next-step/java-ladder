package step2.ladderGame.domain.ladder;


import step2.ladderGame.domain.ladder.pointGenerationStrategy.horizontalLineGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, horizontalLineGenerationStrategy horizontalLineGenerationStrategy, int height) {
        lines.add(new Line(height));
        for (int i = 1; i < countOfPerson; i++) {
            lines.add(new Line(height, horizontalLineGenerationStrategy, lines.get(i-1)));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
