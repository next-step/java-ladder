package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class LadderReward {
    private static final String REGEX = ",";

    @Getter
    private List<String> rewards;

    public LadderReward(String resultValues, int userNumber) {
        List<String> rewards = Arrays.asList(resultValues.split(REGEX));
        validResultValues(rewards, userNumber);

        this.rewards = rewards;
    }

    public String getReward(int index) {
        return rewards.get(index);
    }

    private void validResultValues(List<String> results, int userNumbers) {
        if (results.size() != userNumbers) {
            throw new LadderException(ExceptionType.INVALID_RESULT_SIZE);
        }
    }
}
