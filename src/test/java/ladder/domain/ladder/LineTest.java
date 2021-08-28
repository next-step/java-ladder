package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Line Test")
class LineTest {

    @Test
    @DisplayName("Line 초기화")
    void init() {
        // given
        Line line = Line.generate(() -> true, 5);

        // when
        int actual = line.getPoints().size();

        // then
        assertThat(actual).isEqualTo(5);
    }

    @Test
    @DisplayName("다음 위치 확인")
    void nextPosition() {
        // given
        Line line = Line.generate(() -> true, 3);

        // when
        // then
        assertAll(
                () -> assertThat(line.move(0)).isEqualTo(1),
                () -> assertThat(line.move(1)).isEqualTo(0),
                () -> assertThat(line.move(2)).isEqualTo(2)
        );
    }
}