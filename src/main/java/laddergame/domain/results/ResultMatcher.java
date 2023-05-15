package laddergame.domain.results;

import java.util.Map;
import laddergame.domain.ladder.LadderGame;

public class ResultMatcher {

    private final LadderGame ladderGame;
    private final Results results;

    public ResultMatcher(final LadderGame ladderGame, final Results results) {
        validate(ladderGame, results);
        this.ladderGame = ladderGame;
        this.results = results;
    }

    public String match(String name) {
        MatchingResults matchingResults = ladderGame.matchResult(results);
        return matchingResults.get(name);
    }

    public Map<String, String> matchAll() {
        MatchingResults matchingResults = ladderGame.matchResult(results);
        return matchingResults.getAll();
    }

    private void validate(final LadderGame ladderGame, final Results results) {
        if (ladderGame.getCountOfParticipants() != results.getCount()) {
            throw new IllegalArgumentException("실행결과와 참가자 수 가 일치하지 않습니다.");
        }
    }
}
