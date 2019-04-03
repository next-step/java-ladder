package generator.ladders.impl;

import domain.ladder.Ladders;
import generator.ladders.LaddersGenerator;

public class FixingHeightProbabilityBasedLineGenerator {

    private final LaddersGenerator laddersGenerator;

    private final int height;

    public FixingHeightProbabilityBasedLineGenerator(int height, int percentage) {
        this.laddersGenerator = new ProbabilityBasedLineGenerator(percentage);
        this.height = height;
    }

    public Ladders generate(int lineSize) {
        return laddersGenerator.generate(this.height, lineSize);
    }
}
