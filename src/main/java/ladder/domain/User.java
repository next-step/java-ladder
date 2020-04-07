package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int NAME_LENGTH_LIMIT = 5;

    @Getter
    private String name;
    @Getter
    private String reward;

    public User(String name, String reward) {
        this.name = name;
        this.reward = reward;
    }

    public static List<User> listOf(List<String> userNames, Ladder ladder) {
        List<User> users = new ArrayList<>();

        validNameLength(userNames);

        int index = 0;
        for (String userName : userNames) {
            users.add(new User(userName, ladder.getReward(index)));

            index++;
        }

        return users;
    }

    public boolean equalsUserName(String userName) {
        return this.name.equals(userName);
    }

    private static void validNameLength(List<String> userNames) {
        boolean invalidName = userNames.stream()
                .anyMatch(userName -> userName.length() > NAME_LENGTH_LIMIT);

        if (invalidName) {
            throw new LadderException(ExceptionType.INVALID_NAME_SIZE);
        }
    }
}
