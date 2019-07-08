package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UsersTest {

    private String usersNameStr;

    @BeforeEach
    void setUp() {
        usersNameStr = "lee,ydh,jwlee";
    }

    @Test
    @DisplayName("사용자 생성")
    void createUsers() {
        List<User> usersName = Arrays.asList(
                new User("lee"),
                new User("ydh"),
                new User("jwlee")
        );
        Users users = new Users(usersNameStr);
        assertThat(users.getUsers()).isEqualTo(usersName);
    }

    @Test
    @DisplayName("사용자 이름 최대 길이")
    void userMaxLength() {
        Users users = new Users(usersNameStr);
        assertThat(users.getMaxUserNameLength()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리에 처음 배정된 특정 사용자 위치")
    void userFirstPosition() {
        User user = new User("jwlee");
        Users users = new Users(usersNameStr);
        assertThat(users.userIndex(user)).isEqualTo(2);
    }

}
