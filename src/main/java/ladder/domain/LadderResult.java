package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private final Map<UserName, LadderPrize> lottoResult;

    private LadderResult(Map<UserName, LadderPrize> lottoResult) {
        this.lottoResult = new HashMap<>(lottoResult);
    }

    public static LadderResult of(Users users, LadderPrizes ladderPrizes, Map<Integer, Integer> ladderIndexMap) {
        Map<UserName, LadderPrize> lottoResult = new HashMap<>();
        ladderIndexMap.forEach((userIndex, prizeIndex) -> lottoResult.put(users.findUser(userIndex),
                ladderPrizes.findPrize(prizeIndex)));
        return new LadderResult(lottoResult);
    }

    public Map<UserName, LadderPrize> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

    public LadderPrize findByUser(UserName userName) {
        return lottoResult.get(userName);
    }
}
