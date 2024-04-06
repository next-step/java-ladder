package ladder.domain;

import ladder.domain.Ladder.Ladder;
import ladder.domain.participants.Participants;
import ladder.utils.SplitUtils;

public class LadderGame {

    private final Ladder ladder;
    private final Participants participants;

    public LadderGame(int height, String inputText) {
        this(new Ladder(height, SplitUtils.split(inputText).length), new Participants(inputText) );
    }

    public LadderGame(Ladder ladder, Participants participants) {
        this.ladder = ladder;
        this.participants = participants;
    }

    public Participants doStart() {
        return this.participants.startGame(ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Participants getParticipant() {
        return participants;
    }
}
