package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @Test
    void create() {
        Player player = new Player("pobi");
        assertThat(player).isEqualTo(new Player("pobi"));
    }

    @DisplayName("5글자 초과 입력시 오류")
    @Test
    void error() {
        assertThatThrownBy(() -> new Player("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }
}