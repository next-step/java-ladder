package ladder.domain;

import ladder.exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    public static final Player player = new Player("이상원", 0);

    @DisplayName("이름 생성")
    @Test
    void name() {
        // given
        String name = "LEE";

        // when
        Player playerResult = new Player(name, 0);

        // then
        assertThat(playerResult).isEqualTo(new Player("LEE", 0));
    }

    @Test
    @DisplayName("이름 생성 실패 - 이름 생성은 5글자를 넘을 수 없다.")
    void name_fail() {
        // given
        String name = "LEELEE";

        // expected
        assertThatThrownBy(() -> new Player(name, 0))
                .isInstanceOf(InvalidNameException.class);
    }
}
