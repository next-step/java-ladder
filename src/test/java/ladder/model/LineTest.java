package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LineTest {

    @Test
    @DisplayName("라인에서 첫지점이 true일때 테스트")
    void lineTrue() {
        //given
        Line line = new Line(4, () -> true);

        //when
        List<Boolean> actual = line.getPoints();

        //then
        List<Boolean> expected = List.of(true, false, true);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("라인에서 첫지점이 false일때 테스트")
    void lineFalse() {
        //given
        Line line = new Line(4, () -> false);

        //when
        List<Boolean> actual = line.getPoints();

        //then
        List<Boolean> expected01 = List.of(false, true, false);
        List<Boolean> expected02 = List.of(false, false, false);
        Assertions.assertThat(actual).isIn(expected01, expected02);
    }
}
