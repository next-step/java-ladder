package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {
    private final Supplier<Boolean> DUMMY_LINE_PREDICATE = () -> true;

    @DisplayName("라인은 플레이어 수만큼 연결을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 10})
    public void spec01(final int playerCount) {
        final Line line = new Line(new PlayerCount(playerCount), DUMMY_LINE_PREDICATE);
        assertThat(line.connects()).hasSize(playerCount);
    }

    @DisplayName("라인은 연속으로 그어질 수 없다.")
    @Test
    public void spec02() {
        final Line line = new Line(new PlayerCount(2), () -> true);
        final List<Boolean> connects = line.connects();
        for (int i = 0; i < connects.size()-1; i++) {
            assertThat(!(connects.get(i) && connects.get(i + 1))).isTrue();
        }
    }

    @DisplayName("마지막은 연결할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 7, 10, 21})
    public void spec03(final int playerCount) {
        final Line line = new Line(new PlayerCount(playerCount), DUMMY_LINE_PREDICATE);
        assertThat(line.connects().get(playerCount - 1)).isFalse();
    }

}
