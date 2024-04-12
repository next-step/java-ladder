package nextstep.ladder.domain.result;

import nextstep.ladder.domain.player.Count;
import nextstep.ladder.domain.player.PlayersTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultsTest {

    @DisplayName("경기 결과 목록은")
    @Nested
    class Describe_constructor {

        @DisplayName("입력받은 결과 목록과 참여자 수가 동일할 때, 생성할 수 있다.")
        @Test
        void create() {
            assertThatCode(() -> Results.fromResultNames(PlayersTest.TEST_PLAYER_NAMES, new Count(PlayersTest.TEST_PLAYER_NAMES.size())))
                    .doesNotThrowAnyException();
        }

        @DisplayName("입력받은 결과 목록이 비어있으면, Exception을 발생시킨다.")
        @Test
        void empty() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Results.fromResultNames(Collections.emptyList(), new Count(1)))
                    .withMessage("결과의 개수는 입력한 참여자 수와 동일해야 합니다.");
        }

        @DisplayName("입력받은 결과 목록의 개수와, 참여자 수가 일치하지 않으면 Exception을 발생시킨다.")
        @Test
        void not_same() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Results.fromResultNames(PlayersTest.TEST_PLAYER_NAMES, new Count(PlayersTest.TEST_PLAYER_NAMES.size() + 1)))
                    .withMessage("결과의 개수는 입력한 참여자 수와 동일해야 합니다.");
        }
    }
}
