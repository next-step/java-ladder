package nextstep.ladder.domain.player;

import nextstep.ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("Player는")
    @Nested
    class Describe_constructor {

        @DisplayName("1글자에서 5글자 사이의 이름을 부여할 경우 생성된다.")
        @Test
        void success_when_name_length_between_one_and_five() {
            assertThatCode(() -> new Player("pobi"))
                    .doesNotThrowAnyException();
        }

        @DisplayName("Blank한 이름을 부여할 경우 IllegalArgumentException을 던진다.")
        @ParameterizedTest
        @NullAndEmptySource
        void it_throws_exception_when_empty_name(String name) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player(name))
                    .withMessage("이름은 1글자에서 5글자까지 입력 가능합니다.");
        }

        @DisplayName("5글자를 초과한 이름을 부여할 경우 IllegalArgumentException을 던진다.")
        @Test
        void it_throws_exception_when_length_over_five() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player("여섯글자다아"))
                    .withMessage("이름은 1글자에서 5글자까지 입력 가능합니다.");
        }

    }

}
