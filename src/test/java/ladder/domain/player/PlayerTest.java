package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    @DisplayName("참여자의 이름이 5글자 보다 크면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Player.of("heejeong"));
    }

    @DisplayName("참여자 생성")
    @Test
    void create() {
        assertThatCode(() -> Player.of("pobi"))
                .doesNotThrowAnyException();
    }
}
