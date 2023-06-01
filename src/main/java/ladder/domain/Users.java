package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private List<User> users;
    public Users(String userNames) {
        users = Arrays.stream(split(userNames))
                .map(name -> new User(name))
                .collect(Collectors.toList());
        validCountOfPerson(users.size());
    }

    private static String[] split(String inputNames) {
        return inputNames.split(",");
    }

    private void validCountOfPerson(int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("참여자 수는 2보다 작을 수 없습니다.");
        }
    }

    public int count() {
        return users.size();
    }

    public String usersName() {
        StringBuilder stringBuilder = new StringBuilder();
        users.forEach(user -> {
            stringBuilder
                .append(String.format("%5s", user.name()))
                .append(" ");
        });
        return stringBuilder.toString();
    }
}
