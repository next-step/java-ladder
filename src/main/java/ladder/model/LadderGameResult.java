package ladder.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGameResult {

    private final Map<Member, LadderGameReword> result;

    private LadderGameResult(final Map<Member, LadderGameReword> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static LadderGameResult newInstance(Members members, LadderGameRewords proceedAll) {
        Map<Member, LadderGameReword> ladderGameResult = new LinkedHashMap<>();
        IntStream.range(0, members.count().toInt())
                .forEach(i -> ladderGameResult.put(members.getMembers().get(i), proceedAll.getLadderGameReword(i)));
        
        return new LadderGameResult(ladderGameResult);
    }

    public String get(final String target) {
        if("all".equals(target)) {
            return result.toString();
        }
        return result.get(Member.newInstance(target)).getReword();
    }
}
