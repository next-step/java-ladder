package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @ParameterizedTest
    @CsvSource(value = {"a,a1,a2:3", "b,b2,b3,b4,b5:5"}, delimiter = ':')
    @DisplayName("입력받은 값에서 유저 생성")
    void of(String personsRaw, int countOfUsers) {
        Users users = Users.of(personsRaw);
        String[] split = personsRaw.split(",");
        assertThat(users.toString()).contains(split);
        assertThat(users.countOfUsers()).isEqualTo(countOfUsers);
    }
}