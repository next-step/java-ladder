package ladder.factory;

import ladder.domain.HorizontalPosition;
import ladder.domain.User;
import ladder.domain.UserName;
import ladder.domain.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserNameFactoryTest {

    @Test
    @DisplayName("매개변수에 따라 올바른 이름리스트를 반환해야 합니다.")
    void shouldGetUserName() {
        User userA = this.getUser("testA", 0);
        User userB = this.getUser("testB", 1);
        Users users = new Users(List.of(userA, userB));

        List<UserName> resultA = UserNameFactory.getUserName(users, UserNameFactory.ALL_USER);
        List<UserName> resultB = UserNameFactory.getUserName(users, "testA");

        Assertions.assertThat(resultA).containsOnly(new UserName("testA"), new UserName("testB"));
        Assertions.assertThat(resultB).containsOnly(new UserName("testA"));
    }

    private User getUser(String username, int startPosition) {
        UserName userName = new UserName(username);
        HorizontalPosition userPosition = new HorizontalPosition(startPosition);
        return User.withNameAndPosition(userName, userPosition);
    }
}
