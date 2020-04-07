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

    public LadderGame(String userNameValues, String heightValue, String resultValues) {
        String[] userNames = userNameValues.split(REGEX);

        List<String> results = Arrays.asList(resultValues.split(REGEX));
        validResultValues(results, userNames.length);

        this.ladder = new Ladder(userNames.length, Integer.parseInt(heightValue), results);
        this.users = new Users(Arrays.asList(userNames), ladder);
    }

    private void validResultValues(List<String> results, int userNumbers) {
        if (results.size() != userNumbers) {
            throw new LadderException(ExceptionType.INVALID_RESULT_SIZE);
        }
    }
}
