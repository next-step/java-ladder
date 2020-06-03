package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
}
