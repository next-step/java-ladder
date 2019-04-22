package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class DifficultyLadderConfig implements LadderConfig{
    private int length;
    private int height;
    private int trueCount;

    public DifficultyLadderConfig(int length, Difficulty difficulty) {
        this.length = length;
        this.height = length * difficulty.multiple;
        this.trueCount = (int)(length * difficulty.probability);
    }

    @Override
    public List<Boolean> booleans() {
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

    @Override
    public int height() {
        return height;
    }

    public enum Difficulty {
        GOOD("상", 0.9, 4), FAIR("중", 0.5, 2), POOR("하", 0.2, 1);

        private String name;
        private double probability;
        private int multiple;

        Difficulty(String name, double probability, int multiple) {
            this.name = name;
            this.probability = probability;
            this.multiple = multiple;
        }

        public static Difficulty findByName(String name) {
            return Arrays.stream(values())
                .filter(d -> d.name.equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        }
    }
}
