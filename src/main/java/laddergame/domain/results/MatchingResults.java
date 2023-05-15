package laddergame.domain.results;

import java.util.Collections;
import java.util.Map;

public class MatchingResults {

    private final Map<String, String> matchingResult;

    public MatchingResults(final Map<String, String> matchingResult) {
        this.matchingResult = matchingResult;
    }

    public String get(final String name) {
        if(!matchingResult.containsKey(name)){
            throw new IllegalStateException("찾을 수 없는 참가자 입니다.");
        }
        return matchingResult.get(name);
    }

    public Map<String, String> getAll() {
        return Collections.unmodifiableMap(matchingResult);
    }
}
