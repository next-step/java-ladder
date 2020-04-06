package ladder.domain;

import ladder.Exception.ExceptionType;
import ladder.Exception.LadderException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String REGEX = ",";

    @Getter
    private String name;
    @Getter
    private String reward;

    private User(String name) {
        this.name = name;
    }

    public static List<User> listOf(String userNameValues) {
        String[] userNames = userNameValues.split(REGEX);

        validNameLength(Arrays.asList(userNames));

        return Arrays.stream(userNames)
                .map(username -> new User(username))
                .collect(Collectors.toList());
    }

    public void setReward(int startIndex, Ladder ladder) {
        this.reward = ladder.getRewards(startIndex);
    }

    private static void validNameLength(List<String> userNames) {
        boolean invalidName = userNames.stream()
                .anyMatch(userName -> userName.length() > NAME_LENGTH_LIMIT);

        if (invalidName) {
            throw new LadderException(ExceptionType.INVALID_NAME_SIZE);
        }
    }
}
