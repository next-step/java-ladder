package nextstep.ladder.model;

import java.util.Collections;
import java.util.List;

public class Rewards {
    private static final String NOT_MATCHED_PEOPLE_COUNT_EXCEPTION_MESSAGE = "실행 결과의 수는 입력한 사람의 수와 동일해야 합니다.";

    private final List<String> rewards;

    public Rewards(List<String> rewards, int peopleCount) {
        validate(rewards, peopleCount);
        this.rewards = rewards;
    }

    public List<String> getValue() {
        return Collections.unmodifiableList(rewards);
    }

    public String getRewardByPosition(int position) {
        return rewards.get(position);
    }

    private void validate(List<String> rewards, int peopleCount) {
        if (rewards.size() != peopleCount) {
            throw new IllegalArgumentException(NOT_MATCHED_PEOPLE_COUNT_EXCEPTION_MESSAGE);
        }
    }

}
