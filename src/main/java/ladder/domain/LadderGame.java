package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private static final String REGEX = ",";

    @Getter
    private Ladder ladder;
    @Getter
    private Users users;

    public LadderGame(List<LadderLine> ladderLines, List<String> userNames, List<String> rewards) {
        validResultValues(rewards.size(), userNames.size());

        this.ladder = new Ladder(ladderLines, new LadderReward(rewards));
        this.users = new Users(userNames, ladder);
    }

    public static LadderGame of(String userNameValues, String heightValue, String resultValues) {
        String[] userNames = userNameValues.split(REGEX);
        List<String> rewards = Arrays.asList(resultValues.split(REGEX));

        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0, end = Integer.parseInt(heightValue); i < end; i++) {
            ladderLines.add(LadderLine.of(userNames.length));
        }

        return new LadderGame(ladderLines, Arrays.asList(userNames), rewards);
    }

    private void validResultValues(int rewardNumber, int userNumber) {
        if (rewardNumber != userNumber) {
            throw new LadderException(ExceptionType.INVALID_RESULT_SIZE);
        }
    }
}
