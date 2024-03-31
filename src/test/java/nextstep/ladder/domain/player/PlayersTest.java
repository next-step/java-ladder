package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

public class PlayersTest {

    @DisplayName("Players는")
    @Nested
    class Describe_constructor {

        @DisplayName("참여할 사람 이름 배열로 생성할 수 있다.")
        @Test
        void constructor() {
            final String[] names = new String[]{"pobi", "honux", "crong", "jk"};
            assertThatCode(() -> new Players(names))
                    .doesNotThrowAnyException();
        }

        @DisplayName("참가할 사람을 반드시 필요로 한다.")
        @Test
        void requires_player_names() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Players(Collections.emptyList()))
                    .withMessage("참가자 이름을 입력해주세요.");
        }

        @DisplayName("중복된 참가자 이름을 허용하지 않는다.")
        @Test
        void requires_not_duplicated_names() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Players(new String[]{"pobi", "pobi"}))
                    .withMessage("참가자 이름은 중복될 수 없습니다.");
        }

    }


    @DisplayName("count 메서드는 참가자 수를 반환한다.")
    @Test
    void count() {
        final String[] names = new String[]{"pobi", "honux", "crong", "jk"};
        assertThat(new Players(names).count())
                .isEqualTo(new Count(4));
    }

    @DisplayName("maxNameLength는 참가자 이름 중 가장 긴 이름의 길이를 반환한다.")
    @Test
    void maxNameLength() {
        assertThat(new Players(new String[]{"pobi", "honux", "a", "ab"}).maxNameLength())
                .isEqualTo(new Count(5));

    }

}
