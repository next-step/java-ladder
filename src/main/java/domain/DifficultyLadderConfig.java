package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class DifficultyLadderConfig {
    private int length;
    private int height;
    private int trueCount;

    public DifficultyLadderConfig(int length, Difficulty difficulty) {
        this.length = length;
        this.height = length * difficulty.multiple;
        this.trueCount = (int)(length * difficulty.probability);
    }

    public List<Boolean> booleanList() {
        List<Boolean> booleans = new ArrayList<>();

        Stream.generate(() -> Boolean.TRUE)
            .limit(trueCount)
            .forEach(booleans::add);

        Stream.generate(() -> Boolean.FALSE)
            .limit(length - trueCount)
            .forEach(booleans::add);

        Collections.shuffle(booleans);

        return booleans;
    }

    public int height() {
        return height;
    }

    public enum Difficulty {
        GOOD(1, 4), FAIR(0.5, 2), POOR(0.2, 1);

        private double probability;
        private int multiple;

        Difficulty(double probability, int multiple) {
            this.probability = probability;
            this.multiple = multiple;
        }
    }
}
