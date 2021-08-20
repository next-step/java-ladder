package ladder;

import ladder.domain.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @ParameterizedTest
    @CsvSource({"false, false", "false, true", "true, false", "true, true"})
    void 좌우에_다리가_존재하는지를_의미하는_클래스_Point를_생성하였을_때_Point클래스의_인스턴스인지_확인한다(boolean isExistLeftBridge, boolean isExistRightBridge) {
        assertThat(Point.of(isExistLeftBridge, isExistRightBridge)).isInstanceOf(Point.class);
    }

    @ParameterizedTest
    @CsvSource({"false, false", "false, true", "true, false", "true, true"})
    void 좌우에_다리가_존재하는지를_의미하는_클래스_Point를_생성하였을_때_인자값에_따라_좌우의_다리존재여부를_existLeft와_existRight메서드를_통해_확인할_수_있다(boolean isExistLeftBridge, boolean isExistRightBridge) {
        assertThat(Point.of(isExistLeftBridge, isExistRightBridge).existLeft()).isEqualTo(isExistLeftBridge);
        assertThat(Point.of(isExistLeftBridge, isExistRightBridge).existRight()).isEqualTo(isExistRightBridge);
    }

}
