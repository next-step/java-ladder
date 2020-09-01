package ladder.domain;

import ladder.util.StringUtils;

import java.util.List;

public class Reward {

    private final List<String> names;

    public Reward(String rewardStr) {
        names = StringUtils.splitStringToList(rewardStr);
    }

    public List<String> getNames() {
        return names;
    }

    public String get(int rewardIndex) {
        return names.get(rewardIndex);
    }
}
