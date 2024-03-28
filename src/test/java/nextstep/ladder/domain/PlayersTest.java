package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PlayersTest {

    @DisplayName("Players는 참여할 사람 이름 배열로 생성할 수 있다.")
    @Test
    void constructor() {
        final String[] names = new String[]{"pobi", "honux", "crong", "jk"};
        assertThatCode(() -> new Players(names))
                .doesNotThrowAnyException();
    }

}
