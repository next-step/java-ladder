package ladder.model;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {

    private final Map<Member, LadderGameReword> result;

    private LadderGameResult(final Map<Member, LadderGameReword> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static LadderGameResult newInstance(final Members members, final LadderGameRewords ladderGameRewords) {
        Map<Member, LadderGameReword> ladderGameResult = IntStream.range(0, members.count())
                .boxed()
                .collect(Collectors.toMap(members::get, ladderGameRewords::get));

        return new LadderGameResult(ladderGameResult);
    }

    public LadderGameReword get(final Member member) {
        return result.get(member);
    }

    public Map<Member, LadderGameReword> getResult() {
        return result;
    }
}
