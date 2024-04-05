package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

    @ParameterizedTest
    @CsvSource(value = {"true:true", "false:false"}, delimiter = ':')
    public void Point는_자신의_상태가_true인지_확인하는값에_응답해야한다(boolean input, boolean expected) {
        Point point = new Point(input);
        assertThat(point.isPointTrue()).isEqualTo(expected);
        assertThat(point.isPointFalse()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:false", "false:true"}, delimiter = ':')
    public void Point는_자신의_상태가_false인지_확인하는값에_응답해야한다(boolean input, boolean expected) {
        Point point = new Point(input);
        assertThat(point.isPointFalse()).isEqualTo(expected);
    }

    @Test
    public void Point는_true값일경우_decideNextPoint의_반환값이_false여야한다() {
        Point point = new Point(true);

        assertThat(point.decideNextPoint().isPointTrue()).isEqualTo(false);
    }

}
