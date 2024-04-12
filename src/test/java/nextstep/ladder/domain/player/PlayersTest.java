package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayersTest {
    public static final List<String> TEST_PLAYER_NAMES = List.of("pobi", "honux", "crong", "jk");

    @DisplayName("Players는")
    @Nested
    class Describe_constructor {

        @DisplayName("참여할 사람 이름 배열로 생성할 수 있다.")
        @Test
        void constructor() {
            assertThatCode(() -> Players.from(List.of("pobi", "honux", "crong", "jk")))
                    .doesNotThrowAnyException();
        }

        @DisplayName("참가할 사람을 반드시 필요로 한다.")
        @Test
        void requires_player_names() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Players.from(Collections.emptyList()))
                    .withMessage("참가자 이름을 입력해주세요.");
        }

        @DisplayName("중복된 참가자 이름을 허용하지 않는다.")
        @Test
        void requires_not_duplicated_names() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Players.from(List.of("pobi", "pobi")))
                    .withMessage("참가자 이름은 중복될 수 없습니다.");
        }

    }


    @DisplayName("count 메서드는 참가자 수를 반환한다.")
    @Test
    void count() {
        assertThat(Players.from(List.of("pobi", "honux", "crong", "jk")).count())
                .isEqualTo(new Count(4));
    }

    @DisplayName("maxNameLength는 참가자 이름 중 가장 긴 이름의 길이를 반환한다.")
    @Test
    void maxNameLength() {
        assertThat(Players.from(List.of("pobi", "honux", "a", "ab")).maxNameLength())
                .isEqualTo(new Count(5));

    }

}
