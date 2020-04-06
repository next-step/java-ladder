package ladder.domain;

import ladder.Exception.ExceptionType;
import ladder.Exception.LadderException;
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
        this.users = User.listOf(userNameValues);

        List<String> results = Arrays.asList(resultValues.split(REGEX));

        validResultValues(results);

        this.ladder = new Ladder(this.users.size(), Integer.parseInt(heightValue), results);

        setResult();
    }

    public User findUser(String userName) {
        return users.stream()
                .filter(user -> user.getName().equals(userName))
                .findAny()
                .orElseThrow(() -> new LadderException(ExceptionType.NOT_EXIST_USER));
    }

    private void validResultValues(List<String> results) {
        if (results.size() != this.users.size()) {
            throw new LadderException(ExceptionType.INVALID_RESULT_SIZE);
        }
    }

    private void setResult() {
        int userIndex = 0;

        for (User user : users) {
            user.setReward(userIndex, ladder);

            userIndex++;
        }
    }
}
