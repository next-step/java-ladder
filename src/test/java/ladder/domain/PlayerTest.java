package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @DisplayName("Player 객체 생성 시 이름 5글자 초과 시 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobbii", "bbororo", "tester", "jaewon"})
    public void 이름_5글자_초과_에러발생(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
