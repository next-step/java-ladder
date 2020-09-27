package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @ParameterizedTest
    @CsvSource(value = {"a,a1,a2:3", "b,b2,b3,b4,b5:5"}, delimiter = ':')
    @DisplayName("입력받은 값에서 유저 생성")
    void of(String usersRaw, int countOfUsers) {
        Users users = Users.ofByRaw(usersRaw);
        String[] split = usersRaw.split(",");
        assertThat(users.toString()).contains(split);
        assertThat(users.countOfUsers()).isEqualTo(countOfUsers);
    }
}