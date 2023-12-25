package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Member, String> results = new HashMap<>();

    public LadderResult() {
    }

    public void addResult(Member member, String reward) {
        results.put(member, reward);
    }

    public String getResult(Member member) {
        return results.get(member);
    }

    public String getResult(String memberName) {
        return results.get(new Member(memberName));
    }

    public Map<Member, String> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
