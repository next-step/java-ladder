package nextstep.optional;

import java.util.Arrays;
import java.util.List;

public class Users {
    static final User DEFAULT_USER = new User("codesquad", 100);

    List<User> users = Arrays.asList(
            new User("crong", 35),
            new User("pobi", 30),
            new User("jk", 40),
            new User("honux", 45));

    User getUser(String name) {
        return users.stream()
                .filter(user -> user.matchName(name))  // 이름이 일치하는 사용자 필터링
                .findFirst()                           // 첫 번째 일치하는 사용자 찾기
                .orElse(DEFAULT_USER);                 // 일치하는 사용자가 없으면 DEFAULT_USER 반환

    }
}
