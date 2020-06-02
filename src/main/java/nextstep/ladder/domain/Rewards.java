package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final String DEFAULT_SEPARATOR = ",";

    public static List<String> parseRewardValue(String rewardValues) {
        return Arrays.stream(rewardValues.split(DEFAULT_SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
