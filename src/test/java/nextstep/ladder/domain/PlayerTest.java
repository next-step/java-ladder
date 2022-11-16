package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @DisplayName("사다리 플레이어는 이름이 공백일 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void spec01(final String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(name));
    }

    @DisplayName("사다리 플레이어는 이름은 5자리를 넘을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "제이든제이든"})
    public void spec02(final String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(name));
    }

    @DisplayName("사다리 플레이어는 이름을 조회할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcde", "제이든"})
    public void spec03(final String name) {
        assertThat(new Player(name).name()).isEqualTo(name);
    }
}
