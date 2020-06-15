package laddergame.domain.ladder;

import laddergame.domain.vo.Column;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ColumnTest {
    @DisplayName("열 번호가 1보다 작으면 IllegalArgumentException Throw")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void validateColumn(int column) {
        Assertions.assertThatThrownBy(() -> new Column(column))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("열 번호는 1보다 작을 수 없습니다. - " + column);
    }
}