package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    final static int ONE_RUNG = 1;
    private List<Rung> rungs;

    private Layer(List<Boolean> rungs) {
        this.rungs = build(rungs);
    }

    public static Layer fromEntry(int entry) {
        RandomRungsGenerator rungsGenerator = new RandomRungsGenerator();
        return new Layer(rungsGenerator.generate(entry - ONE_RUNG));
    }

    public static Layer of(List<Boolean> rungs) {
        return new Layer(rungs);
    }

    public List<Rung> getRungs() {
        return rungs;
    }

    private List<Rung> build(List<Boolean> inputRungs) {
        List<Rung> rungs = new ArrayList<>();
        int bound = inputRungs.size();
        for (int index = 0; index < bound; index++) {
            verifyRepeatedTrueValue(inputRungs.get(index), inputRungs.get(index + ONE_RUNG));
            rungs.add(new Rung(inputRungs.get(index)));
        }
        return rungs;
    }

    private void verifyRepeatedTrueValue(Boolean current, Boolean next) {
        if (current && next) {
            throw new IllegalArgumentException("연속된 계단은 만들어 질 수 없어");
        }
    }
}
