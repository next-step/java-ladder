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
    private List<User> users;

    public LadderGame(String userNameValues, String heightValue, String resultValues) {
        String[] userNames = userNameValues.split(REGEX);

        List<String> results = Arrays.asList(resultValues.split(REGEX));
        validResultValues(results, userNames.length);

        this.ladder = new Ladder(userNames.length, Integer.parseInt(heightValue), results);
        this.users = User.listOf(Arrays.asList(userNames), ladder);
    }

    public User findUser(String userName) {
        return users.stream()
                .filter(user -> user.equalsUserName(userName))
                .findAny()
                .orElseThrow(() -> new LadderException(ExceptionType.NOT_EXIST_USER));
    }

    private void validResultValues(List<String> results, int userNumbers) {
        if (results.size() != userNumbers) {
            throw new LadderException(ExceptionType.INVALID_RESULT_SIZE);
        }
    }
}
