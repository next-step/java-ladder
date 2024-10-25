package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<UserName, LadderPrize> lottoResult;

    private LottoResult(Map<UserName, LadderPrize> lottoResult) {
        this.lottoResult = new HashMap<>(lottoResult);
    }

    public static LottoResult of(Users users, LadderPrizes ladderPrizes, Map<Integer, Integer> ladderIndexMap) {
        Map<UserName, LadderPrize> lottoResult = new HashMap<>();
        ladderIndexMap.forEach((userIndex, prizeIndex) -> lottoResult.put(users.findUser(userIndex),
                ladderPrizes.findPrize(prizeIndex)));
        return new LottoResult(lottoResult);
    }

    public Map<UserName, LadderPrize> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
