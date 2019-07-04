package ladder.model;

import ladder.util.RungGenerator;

import java.util.Collections;
import java.util.List;

public class Layer {

    private static final int ONE_RUNG = 1;
    private final List<Rung> rungs;

    public Layer(final List<Rung> rungs) {
        this.rungs = rungs;
    }

    public static Layer of(RungGenerator rungGenerator, int countOfPlayers) {
        return new Layer(rungGenerator.generate(countOfPlayers - ONE_RUNG));
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
