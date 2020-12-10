package ladder.model.group;

import ladder.model.name.wrapper.Reward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards extends Group<Reward> {
    private final static String NAME_DELIMITER = ",";
    private final static String EMPTY_NAME_ERROR_MESSAGE = "올바른 결과들의 이름이 아닙니다.";
    private final static String REWORD_INDEX_ERROR = "해당 위치에 대한 결과가 없습니다.";

    private final static int MIN_WORD_COUNT = 1;

    private Rewards(List<Reward> rewards) {
        super(rewards);
    }

    public static Rewards from(String names) {
        String[] rewardNames = names.split(NAME_DELIMITER);

        if (isNotValid(rewardNames)) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }

        List<Reward> rewards = Arrays.stream(rewardNames)
                .map(Reward::of)
                .collect(Collectors.toList());

        return new Rewards(rewards);
    }

    public String getReward(int idx) {
        if(group.size() <= idx){
            throw new IllegalArgumentException(REWORD_INDEX_ERROR);
        }

        return group.get(idx).toString();
    }

    private static boolean isNotValid(String[] rewardNames) {
        return rewardNames.length < MIN_WORD_COUNT;
    }
}
