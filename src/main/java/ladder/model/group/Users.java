package ladder.model.group;

import ladder.model.name.wrapper.User;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class Users extends Group<User> {
    private final static String NAME_DELIMITER = ",";
    private final static String EMPTY_NAME_ERROR_MESSAGE = "올바른 유저들의 이름이 아닙니다.";

    private final static int MIN_USER_COUNT = 2;

    private Users(List<User> users){
        super(users);
    }

    public static Users from(String names){
        String[] userNames = names.split(NAME_DELIMITER);

        if (isNotValid(userNames)) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }

        List<User> users = Arrays.stream(userNames)
                .map(User::of)
                .collect(Collectors.toList());

        return new Users(users);
    }

    public List<String> getUserNames(){
        return group.stream()
                .map(User::toString)
                .collect(Collectors.toList());
    }

    private static boolean isNotValid(String[] userNames) {
        int setCount = (int) Arrays.stream(userNames)
                .distinct()
                .count();

        return (userNames.length < MIN_USER_COUNT) || (userNames.length != setCount);
    }
}
