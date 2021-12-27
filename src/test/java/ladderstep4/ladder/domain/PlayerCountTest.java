package ladderstep4.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerCountTest {
    @Test
    void 플레이어숫자_2이상의_수로_생성가능하다_동등성가짐() {
        assertThat(new PlayerCount(2)).isEqualTo(new PlayerCount(2));
    }

    @Test
    void 플레이어숫자_생성_1이하의수를_가질수없다() {
        assertThatThrownBy(() -> new PlayerCount(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PlayerCount.INVALID_VALUE_MESSAGE);
    }
}
