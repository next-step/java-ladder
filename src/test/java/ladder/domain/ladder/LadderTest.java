package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @DisplayName("사다리 생성 실패: 사다리의 높이와 기둥의 개수는 최소 1개 이상")
    @ParameterizedTest
    @CsvSource({ "1,0", "0,1", "0,0" })
    void createFailure(final int height, final int playerCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(Height.of(height), playerCount));
    }

    @DisplayName("Ladder 생성")
    @Test
    void create() {
        assertThatCode(() -> Ladder.of(Height.of(Height.MIN_HEIGHT), PillarCount.MIN_COUNT))
                .doesNotThrowAnyException();
    }
}
