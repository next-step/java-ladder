package ladder.view;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.model.LadderGameReword;
import ladder.model.LadderGameRewords;
import ladder.model.Member;
import ladder.model.Members;

public class LadderGameResult {

    private static final int ZERO = 0;
    private final Map<Member, LadderGameReword> result;

    private LadderGameResult(final Map<Member, LadderGameReword> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static LadderGameResult create(final Members members, final LadderGameRewords ladderGameRewords) {
        Map<Member, LadderGameReword> ladderGameResult = IntStream.range(ZERO, members.count())
            .boxed()
            .collect(Collectors.toMap(members::get, ladderGameRewords::get, (item1, item2) -> item1, LinkedHashMap::new));

        return new LadderGameResult(ladderGameResult);
    }

    public LadderGameReword get(final Member member) {
        return result.get(member);
    }

    public Map<Member, LadderGameReword> getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderGameResult)) {
            return false;
        }
        LadderGameResult that = (LadderGameResult) o;
        return Objects.equals(getResult(), that.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult());
    }
}
