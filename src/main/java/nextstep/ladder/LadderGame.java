package nextstep.ladder;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderGame {
    private final Ladder ladder;
    private final Participant participant;
    private final LadderResult result;

    public LadderGame(final Ladder ladder, final Participant participant, final LadderResult result) {
        validateGame(ladder, participant, result);
        this.ladder = ladder;
        this.participant = participant;
        this.result = result;
    }

    public Map<String, String> play() {
        return ladder.start(participant, result);
    }

    private void validateGame(Ladder ladder, Participant participant, LadderResult result) {
        if(!ladder.isRightCondition(participant, result)){
            throw new IllegalStateException("참가자와 사다리타기 결과의 갯수가 같지 않습니다.");
        }
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

    public List<Name> getParticipants() {
        return participant.getParticipants();
    }

    public LadderResult getResult() {
        return result;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
