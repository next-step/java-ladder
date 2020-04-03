package ladder;

import ladder.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {
    @DisplayName("게임에 참여하는 사람의 이름이 5글자를 넘으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "일이삼사오육"})
    void validateNameLengthTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(input);
        });
    }
}
