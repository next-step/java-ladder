package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @Test
    @DisplayName("이름이 5자 이상 넘어가면 에러")
    void createPlayer_nameOver5Length() {
        assertThatThrownBy(() -> {
            new Player("pppppp");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("name must not be over 5");
    }

    @Test
    @DisplayName("이름에 공백이 있으면 에러")
    void createPlayer_nameIsEmpty() {
        assertThatThrownBy(() -> {
            new Player("    ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("name must not be empty");
    }
}