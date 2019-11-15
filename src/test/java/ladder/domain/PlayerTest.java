package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    void 생성() {
        Player player = new Player("pobi");
        assertThat(player).isEqualTo(new Player("pobi"));
    }

    @ParameterizedTest
    @NullSource
    void 생성_게이머_이름_유효값_검증_null(final String name) {
        assertThatThrownBy(() -> {
            new Player(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "abcdef")
    void 생성_게이머_이름_유효값_검증_5글자(final String name) {
        assertThatThrownBy(() -> {
            new Player(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
