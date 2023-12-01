package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("하나의 라인에 존재하는 폭이 동시에 겹치는 경우는 없습니다.")
    @Test
    void notSameConnect() {
        // given
        // when
        Line line = Line.makeLine(5, () -> true);
        // then
        Assertions.assertThat(line.getLine())
                .containsExactly(WidthStatus.connected, WidthStatus.notConnected, WidthStatus.connected, WidthStatus.notConnected);
    }

    @DisplayName("하나의 라인에 존재하는 폭은 전달받은 사람 수보다 1 작습니다.")
    @Test
    void checkLineWidth() {
        // given
        int participatorCount = 5;
        // when
        Line line = Line.makeLine(participatorCount, () -> true);
        // then
        Assertions.assertThat(line.getLine()).hasSize(4);
    }

    @ParameterizedTest(name = "i-1 이 연결되어 있다면 참가자의 위치는 i-1 이 됩니다.")
    @CsvSource(value = {"1, 0", "3, 2"})
    void goLeft(int current, int result) {
        // given
        Participator participator = new Participator("test", current);
        Line line = new Line(List.of(WidthStatus.connected, WidthStatus.notConnected, WidthStatus.connected));
        // when
        line.go(participator);
        // then
        assertThat(participator.getLocation()).isEqualTo(result);
    }

    @ParameterizedTest(name = "i 가 연결되어 있다면 참가자의 위치는 i+1 이 됩니다.")
    @CsvSource(value = {"0, 1", "2, 3"})
    void goRight(int current, int result) {
        // given
        Participator participator = new Participator("test", current);
        Line line = new Line(List.of(WidthStatus.connected, WidthStatus.notConnected, WidthStatus.connected));
        // when
        line.go(participator);
        // then
        assertThat(participator.getLocation()).isEqualTo(result);
    }

    @ParameterizedTest(name = "둘 다 연결되어 있지 않다면 참가자의 위치는 i가 됩니다.")
    @CsvSource(value = {"2, 2", "3, 3"})
    void goStraight(int current, int result) {
        // given
        Participator participator = new Participator("test", current);
        Line line = new Line(List.of(WidthStatus.connected, WidthStatus.notConnected, WidthStatus.notConnected));
        // when
        line.go(participator);
        // then
        assertThat(participator.getLocation()).isEqualTo(result);
    }
}