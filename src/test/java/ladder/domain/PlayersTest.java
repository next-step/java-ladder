package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {
    @DisplayName("입력한 사용자의 이름이 null 일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void create_inputBlank(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Players(names))
                .withMessageContaining("이름은 빈 값을 입력 할 수 없습니다.");
    }

    @DisplayName("입력한 데이터를 ',' 구분자로 하여 나눈다.")
    @ParameterizedTest
    @CsvSource(value = "user1, user2, user3:3", delimiter = ':')
    void create(String names, int expected) {
        Players players = new Players(names);
        assertThat(players.countOfPlayers()).isEqualTo(expected);
    }
}
