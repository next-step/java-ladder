package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private static final String REGEX = ",";

    @Getter
    private Ladder ladder;
    @Getter
    private Users users;

    public LadderGame(List<String> userNames, int heightValue, List<String> rewards) {
        validResultValues(rewards.size(), userNames.size());

        this.ladder = new Ladder(userNames, heightValue, rewards);
        this.users = new Users(userNames, ladder);
    }

    public static LadderGame of(String userNameValues, String heightValue, String resultValues) {
        String[] userNames = userNameValues.split(REGEX);
        List<String> rewards = Arrays.asList(resultValues.split(REGEX));

        return new LadderGame(Arrays.asList(userNames), Integer.parseInt(heightValue), rewards);
    }

    private void validResultValues(int rewardNumber, int userNumber) {
        if (rewardNumber != userNumber) {
            throw new LadderException(ExceptionType.INVALID_RESULT_SIZE);
        }
    }
}
