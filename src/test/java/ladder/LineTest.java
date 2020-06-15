package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("사다리 타기가 라인 수 === 인원 수 테스.")
    @Test
    void LINE_DRAW_LINE_COUNT_TEST() {
        int countOfPersion = 5;
        assertThat(new Line(countOfPersion).getLineCount()).isEqualTo(countOfPersion);
    }

    @DisplayName("사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"5^4",
            "4^3",
            "2^1"},
            delimiter = '^')
    void LINE_DRAW_DUPLICATE_TEST(int countOfPerson, int lineMaxNumber) {
        assertThat(new Line(countOfPerson).getDrawLineCount() < lineMaxNumber).isTrue();
    }
}
