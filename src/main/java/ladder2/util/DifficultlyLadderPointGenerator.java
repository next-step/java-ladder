package ladder2.util;

import ladder2.model.Difficultly;

public class DifficultlyLadderPointGenerator implements LadderPointGenerator {
    private Difficultly difficultly;

    private DifficultlyLadderPointGenerator(Difficultly difficultly) {
        this.difficultly = difficultly;
    }

    public static DifficultlyLadderPointGenerator from(Difficultly difficultly) {
        return new DifficultlyLadderPointGenerator(difficultly);
    }

    public boolean generatePoint() {
        return difficultly.generateValue();
    }
}
