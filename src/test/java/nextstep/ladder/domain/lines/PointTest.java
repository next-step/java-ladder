package nextstep.ladder.domain.lines;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.lines.point.impl.PointImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

    @ParameterizedTest
    @CsvSource(value = {"true:true", "false:false"}, delimiter = ':')
    public void Point는_자신의_상태가_true인지_반환한다(boolean input, boolean expected) {
        PointImpl point = new PointImpl(input);
        assertThat(point.isPointTrue()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:false", "false:true"}, delimiter = ':')
    public void Point는_자신의_상태가_false인지_반환한다(boolean input, boolean expected) {
        PointImpl point = new PointImpl(input);
        assertThat(point.isPointFalse()).isEqualTo(expected);
    }

    @Test
    public void Point가_이전_Point와_연결되었을때_다음_Point와는_연결할_수_없다() {
        PointImpl point = new PointImpl(true);
        assertThat(point.decideNextPoint(true).isPointTrue()).isEqualTo(false);
    }
}
