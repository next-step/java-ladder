package ladder.model;

import ladder.util.RungGenerator;

import java.util.Collections;
import java.util.List;

public class Layer {

    private static final int ONE_RUNG = 1;
    private final List<Boolean> rungs;

    public Layer(final List<Boolean> rungs) {
        this.rungs = rungs;
    }

    public static Layer of(RungGenerator rungGenerator, int countOfPlayers) {
        return new Layer(rungGenerator.generate(countOfPlayers - ONE_RUNG));
    }

    public List<Boolean> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
