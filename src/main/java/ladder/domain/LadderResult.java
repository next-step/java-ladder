package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private final LinkedHashMap<Member, Reword> rewordMap;

    public LadderResult(LinkedHashMap<Member, Reword> rewordMap) {
        this.rewordMap = rewordMap;
    }


    public Reword getReword(Member member) {
        if (!rewordMap.containsKey(member)) {
            throw new IllegalArgumentException("멤버가 존재하지 않습니다.");
        }
        return rewordMap.get(member);
    }

    public int getSize() {
        return rewordMap.size();
    }

    public Map<Member, Reword> getRewordMap() {
        return Collections.unmodifiableMap(rewordMap);
    }
}
