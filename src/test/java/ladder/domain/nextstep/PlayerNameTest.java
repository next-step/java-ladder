package ladder.domain.nextstep;

import ladder.exception.InvalidPlayerNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNameTest {

    @DisplayName("이름으로 플레이어 이름 객체를 생성할 수 있다.")
    @Test
    void playerNameCreateTest() {
        String name = "joe";
        PlayerName playerName = PlayerName.of(name);

        assertThat(playerName.name()).isEqualTo(name);
    }

    @DisplayName("1자 미만 5자 초과 길이의 플레이어 이름을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"joseph", ""})
    void invalidNumberOfPlayersExceptionTest(String name) {
        assertThatThrownBy(() -> PlayerName.of(name))
                .isInstanceOf(InvalidPlayerNameException.class)
                .hasMessage("플레이어 이름은 1자 이상 5자 이하만 가능합니다.");
    }

}