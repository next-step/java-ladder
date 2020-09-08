package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(Users users, LadderHeight ladderHeight) {
        int height = ladderHeight.getLadderHeight();

        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(users.size()));
        }

        return new Ladder(lines);
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public void run(User user) {
        int position = user.getPosition();

        for (Line line : ladder) {
            position = line.move(position);
        }

        user.updateLastPosition(position);
    }
}
