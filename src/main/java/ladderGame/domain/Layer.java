package ladderGame.domain;

import java.util.List;

public class Layer {
    private List<Boolean> rungs;

    public Layer(List<Boolean> rungs) {
        this.rungs = rungs;
    }

    public static Layer of(List<Boolean> rungs) {
        return new Layer(rungs);
    }

    public List<Boolean> getRungs() {
        return rungs;
    }
}
