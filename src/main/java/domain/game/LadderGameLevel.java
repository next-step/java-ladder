package domain.game;

import domain.ladder.Ladders;
import generator.ladders.impl.FixingHeightProbabilityBasedLineGenerator;

import java.util.Arrays;

public enum LadderGameLevel {
    GOOD("상", new FixingHeightProbabilityBasedLineGenerator(20, 70)),
    AVERAGE("중", new FixingHeightProbabilityBasedLineGenerator(10, 40)),
    POOR("하", new FixingHeightProbabilityBasedLineGenerator(5, 20));

    private final FixingHeightProbabilityBasedLineGenerator laddersGenerator;

    private final String name;

    LadderGameLevel(String name, FixingHeightProbabilityBasedLineGenerator generator) {
        this.laddersGenerator = generator;
        this.name = name;
    }

    public static LadderGameLevel generate(String name) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public Ladders createLadders(int lineSize) {
        return laddersGenerator.generate(lineSize);
    }
}
