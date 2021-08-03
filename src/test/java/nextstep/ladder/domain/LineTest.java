package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Line (가로줄)")
class LineTest {

    @DisplayName("[성공] 생성 - with높이")
    @ParameterizedTest
    @CsvSource(value = {
        "5"
    })
    public void create_withHeight(int height) {
        // given

        // when
        Line line = Line.of(height);

        // then
        assertThat(line.size()).isEqualTo(height);
    }

    public static Stream<Arguments> defaultLine() {
        return Stream.of(
            Arguments.of(Line.of(5))
        );
    }

    @DisplayName("[성공] 생성 - with이전가로줄")
    @ParameterizedTest
    @MethodSource("defaultLine")
    public void create_withPrev(Line prev) {
        // given

        // when
        Line current = Line.of(prev);

        // then
        for (int i = 0; i < prev.size(); i++) {
            assertThat(isValid(prev.lineExists(i), current.lineExists(i))).isTrue();
        }
    }

    private boolean isValid(boolean prev, boolean current) {
        if (current && prev) {
            return false;
        }

        return true;
    }
}
