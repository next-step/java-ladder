package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class LinesTest {

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0"}, delimiter = ':')
    void 시작_포지션_값을_통해_최종_포지션_값을_구할_수_있다(int startPosition, int finalPosition) {
        Lines lines = new Lines(List.of(
                Line.from(List.of(new Point(true))),
                Line.from(List.of(new Point(false)))
        ));

        assertThat(lines.finalPosition(startPosition)).isEqualTo(finalPosition);
    }

    @Test
    void 모든_라인의_포지션_수가_동일하지_않으면_예외가_발생한다() {
        Throwable throwable = catchThrowable(() -> new Lines(List.of(
                Line.from(List.of(new Point(true), new Point(false))),
                Line.from(List.of(new Point(false)))
        )));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("모든 라인의 포지션 수는 동일해야합니다.");
    }

    @Test
    void 모든_라인의_포지션_수는_동일해야_한다() {
        Lines lines = new Lines(List.of(
                Line.from(List.of(new Point(true))),
                Line.from(List.of(new Point(false)))
        ));
        assertThat(lines).isNotNull();
    }
}
