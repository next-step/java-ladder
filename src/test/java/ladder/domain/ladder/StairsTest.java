package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StairsTest {

    @DisplayName("기둥의 최소 개수인 1보다 작은 수로 계단을 만들 수 없음")
    @Test
    void createFailure() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Stairs.of(PillarCount.of(PillarCount.MIN_COUNT - 1)));
    }

    @DisplayName("기둥의 개수 만큼 수평을 따라 계단 생성")
    @Test
    void create() {
        assertThatCode(() -> Stairs.of(PillarCount.of(PillarCount.MIN_COUNT)))
                .doesNotThrowAnyException();
    }
}
