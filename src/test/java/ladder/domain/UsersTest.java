package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class UsersTest {

    @DisplayName("Users 객체 생성 테스트")
    @Test
    void Users_객체생성() {
        String[] userNames = {"user1", "user2", "user3"};

        List<User> userNameList = Arrays.stream(userNames)
                .map(User::create)
                .limit(userNames.length)
                .collect(Collectors.toList());

        Users users = Users.create(userNameList);

        Assertions.assertThat(users.size()).isEqualTo(userNameList.size());
    }

}
