package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        List<LadderLine> ladderLines = IntStream.range(0, Integer.parseInt(heightValue))
                .mapToObj(value -> LadderLine.of(userNames.length))
                .collect(Collectors.toList());

        return new LadderGame(ladderLines, Arrays.asList(userNames), rewards);
    }

    private void validResultValues(int rewardNumber, int userNumber) {
        if (rewardNumber != userNumber) {
            throw new LadderException(ExceptionType.INVALID_RESULT_SIZE);
        }
    }
}
