package ladderstep4.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    void 플레이어_생성_최대5글자_동등성을가짐() {
        assertThat(new Player("5five")).isEqualTo(new Player("5five"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "666six")
    void 플레이어_생성_실패_null_empty_6글자이상(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Player.INVALID_NAME_MESSAGE);
    }
}
