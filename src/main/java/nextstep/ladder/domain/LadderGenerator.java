package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {

    private static final Random random = new Random();

    private LadderGenerator() {
    }

    public static Ladder generateLadder(int participantCount, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createRandomLine(participantCount));
        }
        return new Ladder(lines);
    }

    private static Line createRandomLine(int participantCount) {
        Line randomLine = new Line(participantCount);
        for (int cnt = 0; cnt < participantCount - 1; cnt++) {
            boolean isConnected = random.nextBoolean();
            boolean hasBridge = randomLine.hasBridgeAtPosition(cnt);
            if (isConnected && !hasBridge) {
                randomLine.putBridgeAtPosition(cnt);
            }
        }
        return randomLine;
    }
}
