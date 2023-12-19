package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Member, String> results = new HashMap<>();

    public LadderResult() {
    }

    public void addResult(Member member, String string) {
        results.put(member, string);
    }

    public String getResult(Member member) {
        return results.get(member);
    }

    public Map<Member, String> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
