package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PlayersTest {

    @DisplayName("Players는 참여할 사람 이름 배열로 생성할 수 있다.")
    @Test
    void constructor() {
        final String[] names = new String[]{"pobi", "honux", "crong", "jk"};
        assertThatCode(() -> new Players(names))
                .doesNotThrowAnyException();
    }

    @DisplayName("count 메서드는 참가자 수를 반환한다.")
    @Test
    void count() {
        final String[] names = new String[]{"pobi", "honux", "crong", "jk"};
        assertThat(new Players(names).count())
                .isEqualTo(new Count(4));
    }

}
