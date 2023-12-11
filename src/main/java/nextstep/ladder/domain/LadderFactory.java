package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {
    private static final Random random = new Random();

    public static Ladder createLadder(List<String> playerNames, int height) {
        return new Ladder(Players.fromString(playerNames), initLines(playerNames, height));
    }

    private static List<Line> initLines(List<String> playerNames, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LineFactory.createLine(playerNames.size(), random::nextBoolean));
        }
        return lines;
    }
}
