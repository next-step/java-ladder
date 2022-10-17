package nextstep.ladder.model.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nextstep.ladder.model.People;
import nextstep.ladder.model.Rewards;

public class LadderGameResult {
    private final Map<String, String> rewardByPersonName;

    public LadderGameResult(People people, Rewards rewards, List<Integer> resultPositions) {
        rewardByPersonName = createResultMap(people, rewards, resultPositions);
    }

    public String findRewardByPersonName(String personName) {
        return rewardByPersonName.get(personName);
    }

    private Map<String, String> createResultMap(People people, Rewards rewards, List<Integer> resultPositions) {
        var map = new HashMap<String, String>();

        for (int i = 0; i < resultPositions.size(); ++i) {
            int resultPosition = resultPositions.get(i);
            map.put(people.getPeopleNameByPosition(i), rewards.getRewardByPosition(resultPosition));
        }

        return map;
    }
}
