package nextstep.labber;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final int ladderHeight;
    private final List<User> participants;

    public LadderGame(List<User> list, int ladderHeight) {
        this.participants = list;
        this.ladderHeight = ladderHeight;
    }

    public List<Line> createLadder() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < this.ladderHeight; i++) {
            lines.add(new Line(participants.size()));
        }
        return lines;
    }
}
