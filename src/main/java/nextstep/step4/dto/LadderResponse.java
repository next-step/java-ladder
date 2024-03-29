package nextstep.step4.dto;

import nextstep.step4.api.LadderResult;
import nextstep.step4.model.Name;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderResponse {
    private final Map<Name, String> nameAndRewardMap = new LinkedHashMap<>();

    public LadderResponse(List<Name> names, LadderResult ladderResult, List<String> rewards) {
        for (int i = 0; i < names.size(); i++) {
            Name name = names.get(i);
            int endPoint = ladderResult.get(i);
            String reward = rewards.get(endPoint);

            nameAndRewardMap.put(name, reward);
        }
    }

    public Map<Name, String> getNameAndRewardMap() {
        return Collections.unmodifiableMap(nameAndRewardMap);
    }
}
