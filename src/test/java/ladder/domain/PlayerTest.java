package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @DisplayName("참여자는 이름과 시작 위치를 갖고 있다.")
    @Test
    void create() {
        String name = "ohtae";
        int position = 0;

        Player expect = new Player(name, position);

        Player actual = new Player(name, position);

        assertThat(actual).isEqualTo(expect);
    }
}