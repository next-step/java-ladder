package ladder.domain;

import java.util.Collections;
import java.util.List;

import ladder.util.StringUtils;

public class Rewards {

    private final List<String> names;

    public Rewards(String rewardsStr) {
        names = Collections.unmodifiableList(
            StringUtils.splitStringToList(rewardsStr));
    }

    public List<String> getNames() {
        return names;
    }

    public String get(int rewardIndex) {
        return names.get(rewardIndex);
    }
}
