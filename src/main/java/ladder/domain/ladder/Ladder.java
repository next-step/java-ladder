package ladder.domain.ladder;

import ladder.domain.Line;
import ladder.domain.user.Users;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final List<Line> ladder = new ArrayList<>();

    private Ladder() { }

    public static Ladder of(int height, int width) {
        return new Ladder(height,width);
    }
    public static Ladder of(int height, Users users) {
        ladder.add(users);
        return new Ladder(height, users.countOfUser());
    }

    private Ladder(int height, int width) {
        for (int i = 0; i < height; i++) {
            ladder.add(new LadderLine(width));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
