package nextstep.ladder;

import nextstep.ladder.application.PlayLadder;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    @DisplayName("user 객체")
    void cretaeUserTest() {
        String userNameString = "honux";
        String invalidUserNameString = "abcdef";
        User user = new User(new UserName(userNameString));
        assertThat(user.getName()).isEqualTo(userNameString);
        assertThatThrownBy(() -> {
            new User(new UserName(invalidUserNameString));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("user 이름 null, empty")
    void nameEmptyOrNullTest() {
        String emptyName = "";
        String nullName = null;
        assertThatThrownBy(() -> {
            new User(new UserName(emptyName));
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new User(new UserName(nullName));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi", "honux", "crong", "jk"})
    @DisplayName("user 객체 생성")
    void createUserTest(String name) {
        List<String> names = Arrays.asList("pobi","honux","crong","jk");
        List<User> users = PlayLadder.createUser(names);
        assertThat(users.get(names.indexOf(name)).getName()).isEqualTo(name);
    }
}
