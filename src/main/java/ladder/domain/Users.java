package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final int NAME_LENGTH_LIMIT = 5;

    @Getter
    private List<User> users;

    public Users(List<String> userNames, Ladder ladder) {
        this.users = new ArrayList<>();

        validNameLength(userNames);

        int index = 0;
        for (String userName : userNames) {
            users.add(new User(userName, ladder.getReward(index)));

            index++;
        }
    }

    public User findUser(String userName) {
        return users.stream()
                .filter(user -> user.equalsUserName(userName))
                .findAny()
                .orElseThrow(() -> new LadderException(ExceptionType.NOT_EXIST_USER));
    }

    private static void validNameLength(List<String> userNames) {
        boolean invalidName = userNames.stream()
                .anyMatch(userName -> userName.length() > NAME_LENGTH_LIMIT);

        if (invalidName) {
            throw new LadderException(ExceptionType.INVALID_NAME_SIZE);
        }
    }
}
