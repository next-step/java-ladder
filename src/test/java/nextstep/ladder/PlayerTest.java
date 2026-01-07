package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    void 생성() {
        Player player = new Player("pobi");

        assertThat(player.getName()).isEqualTo("pobi");
    }

    @Test
    void 이름을_최대_5글자() {
        assertThatThrownBy(() -> new Player("janghojun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이는 최대 5글자까지 가능합니다.");
    }
}
