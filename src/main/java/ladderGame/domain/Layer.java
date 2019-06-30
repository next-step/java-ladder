package ladderGame.domain;

import ladderGame.util.RungsGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Layer {
    private final static int ONE_RUNG = 1;
    private List<Rung> rungs;

    private Layer(List<Boolean> rungs) {
        verifyRule(rungs);
        this.rungs = rungs.stream()
                .map(Rung::of)
                .collect(Collectors.toList());
    }

    public static Layer ofGenerator(int numberOfPlayer, RungsGenerator rungsGenerator) {
        return new Layer(rungsGenerator.generate(numberOfPlayer - ONE_RUNG));
    }

    public List<Rung> getRungs() {
        return rungs;
    }

    private void verifyRule(List<Boolean> inputRungs) {
        Boolean previous = false;
        int bound = inputRungs.size();
        for (int index = 0; index < bound; index++) {
            Boolean current = inputRungs.get(index);
            verifyRepeatedTrueValue(previous, current);
            previous = current;
        }
    }

    private void verifyRepeatedTrueValue(Boolean current, Boolean next) {
        if (current && next) {
            throw new IllegalArgumentException("연속된 계단은 만들어 질 수 없어");
        }
    }
}
