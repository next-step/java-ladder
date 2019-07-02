package ladderGame.domain;

import ladderGame.util.RungsGenerator;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private final static int ONE_RUNG = 1;
    private List<Rung> rungs;

    private Layer(List<Boolean> rungs) {
        List<Rung> verifiedRung = new ArrayList<>();
        rungs.stream()
                .peek(rung -> verifiedRung.add(Rung.of(rung)))
                .reduce(false, this::verifyRepeatedTrueValue);
        this.rungs = verifiedRung;
    }

    public static Layer ofGenerator(int numberOfPlayer, RungsGenerator rungsGenerator) {
        return new Layer(rungsGenerator.generate(numberOfPlayer - ONE_RUNG));
    }

    public List<Rung> getRungs() {
        return rungs;
    }

    private Boolean verifyRepeatedTrueValue(Boolean previous, Boolean current) {
        if (previous && current) {
            throw new IllegalArgumentException("연속된 계단은 만들어 질 수 없어");
        }
        return current;
    }
}
