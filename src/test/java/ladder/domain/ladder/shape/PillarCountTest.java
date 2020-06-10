package ladder.domain.ladder.shape;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PillarCountTest {

    @DisplayName("기둥의 개수가 1보다 작으면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PillarCount.of(PillarCount.MIN_COUNT - 1));
    }

    @DisplayName("기둥 개수 생성")
    @ParameterizedTest
    @ValueSource(ints = { PillarCount.MIN_COUNT, 10, 100 })
    void create(final int count) {
        assertThatCode(() -> PillarCount.of(count))
                .doesNotThrowAnyException();
    }

    @DisplayName("한 행에 있는 사다리 기둥의 개수가 최소 개수인 1과 같으면 return true 반환")
    @ParameterizedTest
    @MethodSource
    void isMinCount(final PillarCount pillarCount, final boolean expected) {
        assertThat(pillarCount.isMinCount())
                .isEqualTo(expected);
    }

    private static Stream<Arguments> isMinCount() {
        return Stream.of(
                Arguments.of(PillarCount.of(PillarCount.MIN_COUNT), true),
                Arguments.of(PillarCount.of(PillarCount.MIN_COUNT + 1), false)
        );
    }

    @DisplayName("논리적 동치성 비교")
    @Test
    void equals() {
        assertThat(PillarCount.of(PillarCount.MIN_COUNT))
                .isEqualTo(PillarCount.of(PillarCount.MIN_COUNT));
    }
}
