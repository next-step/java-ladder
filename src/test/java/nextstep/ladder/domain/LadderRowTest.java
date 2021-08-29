package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderRowTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10})
    @DisplayName("1열이상의 길이를 가지는 한행의 사다리를 만들수 있다.")
    void createLadder(int ladderWidth) {
        assertThatCode(() -> new LadderRow(ladderWidth))
            .doesNotThrowAnyException();
    }
}