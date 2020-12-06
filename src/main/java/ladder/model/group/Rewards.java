package ladder.model.group;

import ladder.model.move.Point;
import ladder.model.name.wrapper.Reward;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards extends Group<Reward> {
    private final static String NAME_DELIMITER = ",";
    private final static String EMPTY_NAME_ERROR_MESSAGE = "올바른 결과들의 이름이 아닙니다.";
    private final static String NOT_FOUND_NAME = "해당 위치에 대한 결과가 없습니다.";

    private final static int MIN_WORD_COUNT = 1;

    private Rewards(List<Reward> rewards) {
        super(rewards);
    }

    public static Rewards from(String names, int ladderSize) {
        String[] rewardNames = names.split(NAME_DELIMITER);

        if (isNotValid(rewardNames)) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }

        List<Reward> rewards = IntStream.range(0, rewardNames.length)
                .mapToObj(idx -> Reward.of(rewardNames[idx], Point.rewardPoint(idx, ladderSize)))
                .collect(Collectors.toList());

        return new Rewards(rewards);
    }

    public String getReward(Point point) {
        return group.stream()
                .filter(x -> x.match(point))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_NAME))
                .toString();
    }

    private static boolean isNotValid(String[] rewardNames) {
        return rewardNames.length < MIN_WORD_COUNT;
    }
}
