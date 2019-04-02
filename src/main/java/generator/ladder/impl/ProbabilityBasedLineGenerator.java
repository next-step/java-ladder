package generator.ladder.impl;

import domain.ladder.Ladder;
import generator.bool.impl.ProbabilityBasedGenerator;
import generator.ladder.LadderGenerator;

import java.util.function.BooleanSupplier;

public class ProbabilityBasedLineGenerator implements LadderGenerator {

    private final BooleanSupplier booleanGenerator;

    public ProbabilityBasedLineGenerator(int percentage) {
        this.booleanGenerator = new ProbabilityBasedGenerator(percentage);
    }

    @Override
    public Ladder generate(int lineSize) {
        return new Ladder(lineSize, booleanGenerator);
    }
}
