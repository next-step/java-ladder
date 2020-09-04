package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    private int userCount;
    private int ladderHeight;

    private LadderGenerator(int userCount, int ladderHeight) {
        this.userCount = userCount;
        this.ladderHeight = ladderHeight;
    }

    public static LadderGenerator create(int userCount, int ladderHeight) {
        return new LadderGenerator(userCount, ladderHeight);
    }

    public Ladder make() {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(userCount));
        }

        return Ladder.create(lines);
    }
}
