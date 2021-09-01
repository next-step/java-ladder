package ladder.domain;

import ladder.exception.WinningItemException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningItemTest {

    @ParameterizedTest
    @DisplayName("WinningItem 생성 테스트")
    @ValueSource(strings = {"a", "b", "c", "d", "e"})
    void createWinningItemTest(String name) {
        WinningItem winningItem = new WinningItem(name);
        assertThat(winningItem.getItem()).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("WinningItem 생성 예외 테스트")
    @NullAndEmptySource
    void exceptionTest(String name) {
        assertThatThrownBy(() -> new WinningItem(name)).isInstanceOf(WinningItemException.class);
    }
}