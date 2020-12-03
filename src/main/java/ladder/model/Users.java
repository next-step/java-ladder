package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final static String NAME_DELIMITER = ",";
    private final static String EMPTY_NAME_ERROR_MESSAGE = "올바른 유저들의 이름이 아닙니다.";

    private final static int MIN_USER_COUNT = 2;
    
    private final List<Name> users;

    private Users(List<Name> users) {
        this.users = users;
    }

    public static Users from(String names){
        String[] userNames = names.split(NAME_DELIMITER);
        if (isNotValid(userNames)) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
        List<Name> users = Arrays.stream(userNames)
                .map(Name::new)
                .collect(Collectors.toList());

        return new Users(users);
    }

    public int countOfPerson() {
        return users.size();
    }

    private static boolean isNotValid(String[] userNames) {
        int setCount = (int) Arrays.stream(userNames)
                .distinct()
                .count();

        return (userNames.length < MIN_USER_COUNT) || (userNames.length != setCount);
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(Name::toString)
                .collect(Collectors.toList());
    }
}
