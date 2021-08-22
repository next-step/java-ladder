package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ladder.domain.Point;
import ladder.strategy.AlwaysMovableStrategy;
import ladder.strategy.NoMovableStrategy;

class PointTest {
    @DisplayName("좌우에_다리가_존재하는지를_의미하는_클래스_Point를_생성하였을_때_Point클래스의_인스턴스인지_확인한다")
    @ParameterizedTest
    @CsvSource({"false, false", "false, true", "true, false", "true, true"})
    void ofTest(boolean isExistLeftBridge, boolean isExistRightBridge) {
        assertThat(Point.of(isExistLeftBridge, isExistRightBridge)).isInstanceOf(Point.class);
    }

    @DisplayName("좌우에_다리가_존재하는지를_의미하는_클래스_Point를_생성하였을_때_인자값에_따라_좌우의_다리존재여부를_existLeft와_existRight메서드를_통해_확인할_수_있다")
    @ParameterizedTest
    @CsvSource({"false, false", "false, true", "true, false", "true, true"})
    void existTest(boolean isExistLeftBridge, boolean isExistRightBridge) {
        assertThat(Point.of(isExistLeftBridge, isExistRightBridge).existLeft()).isEqualTo(isExistLeftBridge);
        assertThat(Point.of(isExistLeftBridge, isExistRightBridge).existRight()).isEqualTo(isExistRightBridge);
    }

    @DisplayName("Point생성의 전략이 주어지면 좌우생성여부를 결정되며, 좌우생성여부를 확인할 수 있다")
    @Test
    void strategyTest() {
        assertThat(Point.of(new NoMovableStrategy(), new AlwaysMovableStrategy()).existLeft()).isFalse();
        assertThat(Point.of(new NoMovableStrategy(), new AlwaysMovableStrategy()).existRight()).isTrue();
        assertThat(Point.of(new AlwaysMovableStrategy(), new NoMovableStrategy()).existLeft()).isTrue();
        assertThat(Point.of(new AlwaysMovableStrategy(), new NoMovableStrategy()).existRight()).isFalse();
    }

}
