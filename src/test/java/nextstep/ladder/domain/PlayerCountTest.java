package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerCountTest {

    @DisplayName("플레이어 수는 2 이상이어야 한다.")
    @Test
    public void spec01() {
        Assertions.assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new PlayerCount(1)),
                () -> assertThatNoException().isThrownBy(() -> new PlayerCount(2))
        );
    }

    @DisplayName("플레이어 수는 조회 가능하다.")
    @ParameterizedTest
    @ValueSource(ints =  {2, 5, 9, 10})
    public void spec02(final int count) {
        assertThat(new PlayerCount(count).count()).isEqualTo(count);
    }
}
