package nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private final Map<Integer, Integer> result;

    public LadderResult(Ladder ladder) {
        result = ladder.result();
    }

    public List<Bonus> getOrderedBonuses(List<Bonus> bonusList) {
        List<Bonus> ordered = new ArrayList<>(bonusList.size());
        for (int i = 0; i < bonusList.size(); i++) {
            int bonusIndex = result.get(i);
            ordered.add(bonusList.get(bonusIndex));
        }
        return ordered;
    }

    public int get(int index) {
        return result.get(index);
    }
}
