package nextstep.ladder.domain.reward;

import nextstep.ladder.domain.exceptions.InvalidRewardsParameterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final String DEFAULT_SEPARATOR = ",";

    private List<Reward> values;

    private Rewards(List<Reward> rewardList) {
        this.values  = new ArrayList<>(rewardList);
    }

    public static Rewards create(String rewardValues) {
        validate(rewardValues);
        return new Rewards(parseRewardValues(rewardValues));
    }

    public static List<Reward> parseRewardValues(String rewardValues) {
        return Arrays.stream(rewardValues.split(DEFAULT_SEPARATOR))
                .map(String::trim)
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.values.size();
    }

    public Reward getByIndex(int index) {
        return this.values.get(index);
    }

    public List<String> getRewardNameValues() {
        return this.values.stream()
                .map(Reward::getName)
                .collect(Collectors.toList());
    }

    private static void validate(String rewardValues) {
        if (rewardValues == null) {
            throw new InvalidRewardsParameterException("RewardValues must not be null");
        }
        if (rewardValues.trim().isEmpty()) {
            throw new InvalidRewardsParameterException("RewardValues must not be empty");
        }
    }
}
