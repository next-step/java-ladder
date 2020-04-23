package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {
    @Test
    void size() {
        String userNames = "crong,pobi,bipo";
        assertThat(Users.of(userNames, ",").size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:crong", "1:pobi", "2:bipo"}, delimiter = ':')
    void getUser(int position, String userName) {
        String userNames = "crong,pobi,bipo";
        Users users = Users.of(userNames, ",");
        assertThat(users.getUser(new Position(position))).isEqualTo(new User(userName));
    }
}
