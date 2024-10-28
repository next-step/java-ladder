package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {

    private static final int MINIMUM_SPACE = 2;

    private static final Random random = new Random();

    private int participantCount;
    private int height;

    public LadderGenerator(int participantCount, int height) {
        this.participantCount = participantCount;
        this.height = height;
    }

    public Ladder generateLadder() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createRandomLine());
        }
        return new Ladder(lines);
    }

    private Line createRandomLine() {
        List<Boolean> points = new ArrayList<>();
        int cnt = 0;
        while (cnt != participantCount) {
            if (hasTwoSpace(cnt) && random.nextBoolean()) {
                points.add(Boolean.TRUE);
                points.add(Boolean.TRUE);
                cnt += 2;
                continue;
            }
            points.add(Boolean.FALSE);
            cnt++;
        }
        return new Line(points);
    }

    private boolean hasTwoSpace(int cnt) {
        return cnt + MINIMUM_SPACE <= participantCount;
    }
}
