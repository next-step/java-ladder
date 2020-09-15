package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<LadderLine> ladder;

    private Ladder(List<LadderLine> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(Users users, LadderHeight ladderHeight) {
        int height = ladderHeight.getLadderHeight();

        List<LadderLine> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(LadderLine.init(users.size()));
        }

        return new Ladder(lines);
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }

    public int run(int position) {

        for (LadderLine line : ladder) {
            position = line.move(position);
        }

        return position;
    }
}
