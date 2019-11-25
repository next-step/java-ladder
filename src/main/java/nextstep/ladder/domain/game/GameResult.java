package nextstep.ladder.domain.game;

import nextstep.ladder.domain.participant.Participant;

public class GameResult {

    private Participant participant;
    private String result;

    public GameResult(Participant participant, String result) {
        this.participant = participant;
        this.result = result;
    }

    public String getName() {
        return participant.getName();
    }

    public String getScore() {
        return result;
    }
}
