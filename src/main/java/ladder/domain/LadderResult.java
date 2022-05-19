package ladder.domain;

import java.util.Collections;
import java.util.Map;

public class LadderResult {
    private final Map<Participant, Score> ladderResults;

    public LadderResult(Map<Participant, Score> ladderResults) {
        validateLadderResults(ladderResults);
        this.ladderResults = ladderResults;
    }

    public Map<Participant, Score> ladderResults() {
        return Collections.unmodifiableMap(ladderResults);
    }

    public String getScore(String participantName) {
        return ladderResults.keySet().stream()
                .filter(participant -> participant.isParticipant(participantName))
                .map(ladderResults::get)
                .map(Score::score)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("찾고자 하는 참가자가 없습니다. 현재 참여자 현황 : %s", ladderResults.keySet())));
    }

    private void validateLadderResults(Map<Participant, Score> ladderResults) {
        if (ladderResults == null) {
            throw new IllegalArgumentException("전달 받은 사다리 결과는 null 일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LadderResult that = (LadderResult) o;

        return ladderResults.equals(that.ladderResults);
    }

    @Override
    public int hashCode() {
        return ladderResults.hashCode();
    }
}
