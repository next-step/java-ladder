package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    private static final String ALL = "all";

    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public List<Integer> play(String name) {
        if(name.toLowerCase().equals(ALL)) {
            return ladder.playAll();
        }
        int startPosition = participants.getStartPosition(User.of(name));
        return Collections.singletonList(ladder.play(startPosition));
    }
}
