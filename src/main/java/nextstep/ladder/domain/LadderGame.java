package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Participants participants;
    private final Lines lines;
    private final List<LadderResult> results;

    public LadderGame(Participants participants, Lines lines, List<LadderResult> results) {
        this.participants = participants;
        this.lines = lines;

        validateResults(results);
        this.results = results;
    }

    private void validateResults(List<LadderResult> results) {
        if (results.size() != participants.size()) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치하지 않습니다.");
        }
    }

    public LadderResults play() {
        Map<Participant, LadderResult> gameResults = generateGameResults();
        return new LadderResults(gameResults);
    }

    private Map<Participant, LadderResult> generateGameResults() {
        return IntStream.range(0, participants.size())
                .boxed()
                .collect(Collectors.toMap(participants.getParticipants()::get, this::calculateResult));
    }

    private LadderResult calculateResult(int index) {
        return results.get(lines.move(index));
    }

}
