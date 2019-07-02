package ladder.model;

import ladder.util.RungGenerator;

import java.util.List;

public class Layer {

    private final List<Rung> rungs;

    public Layer(final List<Rung> rungs) {
        this.rungs = rungs;
    }

    public static Layer of(RungGenerator rungGenerator, int countOfPlayers) {
        return new Layer(rungGenerator.generate(countOfPlayers - 1));
    }

    public List<Rung> getRungs() {
        return rungs;
    }
}
