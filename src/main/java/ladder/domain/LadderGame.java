package ladder.domain;

import ladder.Exception.ExceptionType;
import ladder.Exception.LadderException;
import ladder.utils.LadderGenerator;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private static final String REGEX = ",";
    private static final int NAME_LENGTH_LIMIT = 5;

    @Getter
    private Ladder ladder;

    @Getter
    private List<String> users;

    public LadderGame(String userNameValues, String heightValue) {
        String[] userNames = userNameValues.split(REGEX);

        validNameLength(Arrays.asList(userNames));

        this.ladder = LadderGenerator.createLadder(userNames.length, Integer.parseInt(heightValue));
        this.users = Arrays.asList(userNames);
    }

    private void validNameLength(List<String> userNames) {
        boolean invalidName = userNames.stream()
                .anyMatch(userName -> userName.length() > NAME_LENGTH_LIMIT);

        if (invalidName) {
            throw new LadderException(ExceptionType.INVALID_NAME_SIZE);
        }
    }
}
