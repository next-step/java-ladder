package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public String getResult(String memberName) {
        return Optional.ofNullable(results.get(new Member(memberName)))
                .orElseThrow(() -> new IllegalArgumentException(String.format("입력하신 %s는 존재하지 않는 이름입니다.", memberName)));
    }

    public Map<Member, String> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
