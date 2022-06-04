package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.exception.NeedMoreResultValueException;
import ladder.exception.NotEqualResultValueException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Rewards {
    private static final int MIN_VALUE_NUM = 2;

    private List<String> resultValueList;

    public Rewards(String values, int playerNum) {
        String[] result = values.split(",");

        validate(result, playerNum);

        this.resultValueList = Arrays.asList(result);
    }

    public Rewards(String values) {
        this(values, 0);
    }

    private void validate(String[] result, int playerNum) {
        resultValueNumValidate(result);

        equalValidate(result, playerNum);
    }

    private void resultValueNumValidate(String[] result) {
        if (result.length < MIN_VALUE_NUM) {
            throw new NeedMoreResultValueException("결과는 무조건 1개 이상이어야합니다.");
        }
    }

    private void equalValidate(String[] result, int playerNum) {
        if (result.length != playerNum) {
            throw new NotEqualResultValueException("게임 결과의 수와 플레이어의 수가 다릅니다.");
        }
    }

    public int searchPlayerReward(Ladder ladder, int startWidthPos) {
        int nowHeight = 0;
        int maxHeight = ladder.getLines().size();
        int nowWidth = startWidthPos;

        while (maxHeight > nowHeight) {
            Line line = ladder.getLines().get(nowHeight);

            nowWidth = line.move(nowWidth);

            nowHeight += 1;
        }

        return nowWidth;
    }

    public Stream<String> stream() {
        return resultValueList.stream();
    }

    public String findRewardName(int rewardPos) {
        return resultValueList.get(rewardPos);
    }
}
