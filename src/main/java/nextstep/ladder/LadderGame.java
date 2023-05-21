package nextstep.ladder;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderGame {
    private Ladder ladder;
    private Participant participant;
    private LadderResult result;
    private Map<String, String> gameResult;

    private LadderGame() {

    }

    public LadderGame(final Ladder ladder, final Participant participant, final LadderResult result) {
        this.ladder = ladder;
        this.participant = participant;
        this.result = result;
    }

    public void start(){
        gameResult = ladder.start(participant, result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGame that = (LadderGame) o;
        return Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }

    public Participant getParticipant() {
        return participant;
    }

    public List<Name> getParticipants(){
        return participant.getParticipants();
    }

    public LadderResult getResult(){
        return result;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Map<String, String> gameResult(){
        return gameResult;
    }
}
