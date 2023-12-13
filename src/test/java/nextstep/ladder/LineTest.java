package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class LineTest {

    @Test
    void 라인은_최소_1개_이상의_포인트가_있어야_한다() {
        assertThat(catchThrowable(() -> Line.from(List.of())))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인은 최소 1개 이상의 포인트가 있어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"0: 1", "1:0", "2:2"}, delimiter = ':')
    void 라인은_시작_포지션에서_다음_포지션_값을_구할_수_있다(int startPosition, int nextPosition) {
        Line line = Line.from(List.of(new Point(true), new Point(false)));
        assertThat(line.nextPosition(startPosition)).isEqualTo(nextPosition);
    }

    @Test
    void 라인은_연속된_포인트를_가질_수_없다() {
        Throwable throwable = catchThrowable(() -> Line.from(List.of(new Point(true), new Point(true))));
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인은 연속된 활성 포인트를 가질 수 없습니다.");
    }
}
