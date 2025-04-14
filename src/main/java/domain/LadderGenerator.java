package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    private static final Random RANDOM = new Random();

    public static Ladder generate(int playerCount, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.generate(playerCount, RANDOM));
        }
        return new Ladder(lines);
    }
}
