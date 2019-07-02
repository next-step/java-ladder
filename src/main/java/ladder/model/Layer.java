package ladder.model;

import java.util.List;

public class Layer {

    private final List<Rung> rungs;

    public Layer(final List<Rung> rungs) {
        this.rungs = rungs;
    }

    public List<Rung> getRungs() {
        return rungs;
    }
}
