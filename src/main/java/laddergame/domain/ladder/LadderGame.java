package laddergame.domain.ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import laddergame.domain.line.Line;
import laddergame.domain.results.MatchingResults;
import laddergame.domain.person.Participants;
import laddergame.domain.results.Results;

public class LadderGame {

    private final Ladder ladder;
    private final Participants participants;

    private LadderGame(final Ladder ladder, final Participants participants) {
        this.ladder = ladder;
        this.participants = participants;
    }

    public static LadderGame create(Ladder ladder, Participants participants) {
        return new LadderGame(ladder, participants);
    }

    public List<String> getNames() {
        return participants.getNames();
    }

    public List<Line> getLinePerDepth() {
        return ladder.getLines();
    }

    public MatchingResults matchResult(Results results) {
        Map<String, String> matchingResult = new HashMap<>();

        List<String> names = participants.getNames();
        for (final String name : names) {
            var position = participants.getPosition(name);
            var resultIndex = ladder.getMatchedIndex(position);
            var result = results.get(resultIndex);
            matchingResult.put(name, result);
        }

        return new MatchingResults(matchingResult);
    }

    public int getCountOfParticipants() {
        return participants.getCount();
    }
}