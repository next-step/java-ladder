package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    private int userCount;
    private LadderHeight ladderHeight;

    private LadderGenerator(Users users, LadderHeight ladderHeight) {
        this.userCount = users.size();
        this.ladderHeight = ladderHeight;
    }

    public static LadderGenerator create(Users users, LadderHeight ladderHeight) {
        return new LadderGenerator(users, ladderHeight);
    }

    public Ladder make() {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight.getLadderHeight(); i++) {
            lines.add(new Line(userCount));
        }

        return Ladder.create(lines);
    }
}
