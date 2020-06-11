package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {


    @DisplayName("이름은 5자 이하여야 한다")
    @ParameterizedTest
    @CsvSource("pobi,honux,crong,jk")
    public void create_nameUnder5_shouldSuccess(String name) {
        User user = new User(name);
        assertThat(user.getName()).isEqualTo(name);
    }

    @DisplayName("이름은 5자 보다 크면 예외 발생")
    @ParameterizedTest
    @CsvSource("pobi56,honux678,crong6789,jk3456")
    public void create_nameOver5_shouldFail(String name) {
        assertThatThrownBy(() -> {
            User user = new User(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
