package nextstep.ladder.domain;

import nextstep.ladder.domain.impl.WinningPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningPrizeTest {

    @DisplayName("string을 매개변수로 WinningPrize를 생성한다.")
    @Test
    void create() {
        String name = "꽝";
        assertThat(new WinningPrize(name)).isEqualTo(new WinningPrize(name));
    }

    @DisplayName("WinningPrize 이름은 5글자를 초과하면 안된다.")
    @Test
    void validPlayerNameLength() {
        String name = "300000";
        assertThatThrownBy(() -> new WinningPrize(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("WinningPrize 이름은 공백 혹은 NULL 이 위치하면 안된다.")
    @Test
    void validEmptyOrNull() {
        assertThatThrownBy(() -> new WinningPrize(null))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningPrize(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningPrize("        "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
