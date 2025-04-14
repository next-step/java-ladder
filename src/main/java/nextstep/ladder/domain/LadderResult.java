package nextstep.ladder.domain;

import nextstep.ladder.domain.prize.LadderPrize;
import nextstep.ladder.domain.prize.LadderPrizes;
import nextstep.ladder.domain.user.LadderUser;
import nextstep.ladder.domain.user.LadderUsers;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResult {
    private final Map<LadderUser, LadderPrize> value;

    public LadderResult(LadderUsers ladderUsers, LadderPrizes ladderPrizes) {
        if (ladderUsers.size() != ladderPrizes.size()) {
            throw new IllegalArgumentException("유저와 결과 수가 같지 않습니다.");
        }

        this.value = IntStream.range(0, ladderUsers.size()).boxed()
            .collect(Collectors.toMap(ladderUsers::get, ladderPrizes::get));
    }

    public Map<String, String> getStringValues() {
        return value.entrySet().stream()
            .collect(Collectors.toMap(entry -> entry.getKey().getName(), entry -> entry.getValue().getValue()));
    }
}
