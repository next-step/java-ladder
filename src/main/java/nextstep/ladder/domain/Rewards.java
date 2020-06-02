package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.InvalidRewardsParameterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {
    private static final String DEFAULT_SEPARATOR = ",";

    private List<Reward> values;

    private Rewards(List<Reward> rewardList) {
        this.values  = new ArrayList<>(rewardList);
    }

    public static Rewards create(Players players, String rewardValues) {
        List<String> rewardValueList = parseRewardValues(rewardValues);
        validate(players.size(), rewardValueList.size());

        List<Reward> rewardList = IntStream.range(0, players.size())
                .mapToObj(num -> new Reward(rewardValueList.get(num), players.getPlayerOfLocation(num)))
                .collect(Collectors.toList());
        return new Rewards(rewardList);
    }

    public static List<String> parseRewardValues(String rewardValues) {
        return Arrays.stream(rewardValues.split(DEFAULT_SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.values.size();
    }

    private static void validate(int playersSize, int rewardValueSize) {
        if (playersSize != rewardValueSize) {
            throw new InvalidRewardsParameterException("Players size and rewards size must equal");
        }
    }
}
