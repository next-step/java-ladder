package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResults {
    private final Map<Participant, LadderResult> ladderResults;

    public LadderResults(Participants participants, String inputLadderResults) {
        List<LadderResult> ladderResults = parseLadderResults(inputLadderResults);
        validateLadderResults(participants, ladderResults);

        this.ladderResults = IntStream.range(0, participants.size())
                .boxed()
                .collect(Collectors.toMap(participants.getParticipants()::get, ladderResults::get));
    }

    public LadderResult getLadderResultByParticipant(Participant participant) {
        return Optional.ofNullable(ladderResults.get(participant))
                .orElseThrow(() -> new IllegalArgumentException(participant.getName() + " 참가자가 존재하지 않습니다."));
    }

    public Map<Participant, LadderResult> getLadderResults() {
        return ladderResults;
    }

    private void validateLadderResults(Participants participants, List<LadderResult> ladderResults) {
        if (participants.size() != ladderResults.size()) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치하지 않습니다.");
        }
    }

    private List<LadderResult> parseLadderResults(String inputLadderResults) {
        return Arrays.stream(inputLadderResults.split(","))
                .map(String::trim)
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

}