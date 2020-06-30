package nextstep.ladder.domain.users;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("참여자 생성 테스트")
class UserTest {

    @DisplayName("이름의 길이를 입력 받아 생성")
    @ParameterizedTest
    @CsvSource(value = {"pobi", "honux", "crong", "jk"}, delimiter = ',')
    public void getName_ReturnName(String name) {
        User user = new User(name);
        assertThat(user.getName()).isEqualTo(name);
    }

    @DisplayName("이름의 길이가 5자 초과하면 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"pobi56", "honux678", "crong6789", "jk3456"}, delimiter = ',')
    public void create_WithNameLengthMoreThan5_ExceptionThrown(String name) {
        assertThatThrownBy(() -> {
            new User(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
