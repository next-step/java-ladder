package ladderGame.domain;

import java.util.List;

public class Layer {
    final static int ONE_RUNG = 1;
    private List<Boolean> rungs;

    private Layer(List<Boolean> rungs) {
        this.rungs = rungs;
    }

    public static Layer fromEntry(int entry) {
        RandomRungsGenerator rungsGenerator = new RandomRungsGenerator();
        return new Layer(rungsGenerator.generate(entry - ONE_RUNG));
    }

    public static Layer of(List<Boolean> rungs) {
        return new Layer(rungs);
    }

    public List<Boolean> getRungs() {
        return rungs;
    }
}
