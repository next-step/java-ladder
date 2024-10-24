package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResult {
    private final Map<Member, Reword> rewordMap;

    public LadderResult(Map<Member, Reword> rewordMap) {
        this.rewordMap = rewordMap;
    }

    public static LadderResult of(Points point, Members members, Rewords rewords) {
        Map<Member, Reword> map = new LinkedHashMap<>();
        IntStream.range(0, members.getSize())
                .forEach(index -> map.put(members.getMember(index), rewords.get(point.get(index))));
        return new LadderResult(map);
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
