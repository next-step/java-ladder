package ladder;

import ladder.domain.Player;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @ParameterizedTest(name = "이름_길이_Test")
    @ValueSource(strings = {"manager", "notebook"})
    public void 이름_길이_Test(String input) {
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자입니다");
    }

    @ParameterizedTest(name = "이름_공백_Test")
    @ValueSource(strings = {"do g", "ap ple", "po bi"})
    public void 이름_공백_Test(String input) {
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백을 포함할 수 없습니다");
    }

}
