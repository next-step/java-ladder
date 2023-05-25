package nextstep.ladder.domain.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final String SPLIT_REGEX = ",";
    private final List<User> users = new ArrayList<>();

    public Users(String input) {
        validate(input);
        String[] names = input.split(SPLIT_REGEX);
        Arrays.stream(names).forEach((name) -> users.add(new User(name)));
    }

    public void add(User user) {
        this.users.add(user);
    }

    public int userCount() {
        return this.users.size();
    }

    public User findUser(int index) {
        return this.users.get(index);
    }

    private void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 빈값일 수는 없습니다.");
        }
    }

    @Override
    public String toString() {
        return users.stream().map(User::toString).collect(Collectors.joining(""));
    }

}