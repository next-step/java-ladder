package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;

    public static LadderGame of(List<String> names, List<Line> lines) {
        Participants participants = Participants.of(names);
        Ladder ladder = Ladder.of(lines);
        return new LadderGame(participants, ladder);
    }

    public static LadderGame of(List<String> names, int height) {
        Participants participants = Participants.of(names);
        Ladder ladder = Ladder.of(participants.numberOf(), height);
        return new LadderGame(participants, ladder);
    }

    private LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public int getParticipantsSize() {
        return this.participants.numberOf();
    }

    public int getLadderHeight() {
        return this.ladder.getHeight();
    }

    public Participants getParticipants() {
        return this.participants;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

}
