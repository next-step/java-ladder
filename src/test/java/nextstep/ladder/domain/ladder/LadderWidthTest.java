package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.size.LadderWidth;
import nextstep.ladder.domain.ladder.size.TooNarrowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderWidthTest {

    @DisplayName("폭이 2미만이라면 예외를던진다.")
    @ParameterizedTest(name = "[{index}] width: {0}")
    @ValueSource(ints = {-100, 0, 1})
    void create_notPositive_throwsException(int width) {
        assertThatThrownBy(() -> new LadderWidth(width))
                .isInstanceOf(TooNarrowException.class);
    }

    @DisplayName("bodyWidth = width -2")
    @ParameterizedTest(name = "[{index}] bodyWidth: {0}, width: {1}")
    @CsvSource({
            "4, 6",
            "100, 102"
    })
    void bodyWidth(int bodyWidth, int width) {
        LadderWidth ladderWidth = new LadderWidth(width);
        assertThat(ladderWidth.bodyWidth()).isEqualTo(bodyWidth);
    }

}
