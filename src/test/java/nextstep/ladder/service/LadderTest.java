package nextstep.ladder.service;

import nextstep.ladder.domain.Bar;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Position;
import nextstep.ladder.wrapper.Ladder;
import nextstep.ladder.wrapper.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    private static Stream<Arguments> ladderRideEntry() {
        return Stream.of(
                Arguments.of(Position.valueOf(0), Position.valueOf(1)),
                Arguments.of(Position.valueOf(1), Position.valueOf(0)),
                Arguments.of(Position.valueOf(2), Position.valueOf(2))
        );
    }

    @DisplayName("Ladder 생성 시 Height 일치 테스트")
    @Test
    void create_생성_테스트() {
        // given
        Line firstLine = Line.valueOf(Bar.init(), Bar.valueOf(false), Bar.valueOf(true));
        Line secondLine = Line.valueOf(Bar.init(), Bar.valueOf(true), Bar.valueOf(false));
        // when
        List<Line> ladder = Ladder.valueOf(firstLine, secondLine).lines();
        int expected = Height.valueOf(2).size();
        // then
        assertThat(ladder.size()).isEqualTo(expected);
    }

    @DisplayName("Ladder 생성 시 line 설정까지 추가")
    @Test
    void create_전략_생성_테스트() {
        // given
        Ladder ladder = Ladder.valueOf(Line.valueOf(Bar.init(), Bar.valueOf(true), Bar.valueOf(false)));
        // when
        Line line = ladder.lines().get(0);
        List<Bar> bars = line.points().bars();
        // then
        assertAll(
                () -> assertThat(bars.get(0)).isEqualTo(Bar.init()),
                () -> assertThat(bars.get(1)).isEqualTo(Bar.valueOf(true)),
                () -> assertThat(bars.get(2)).isEqualTo(Bar.valueOf(false))
        );
    }

    @DisplayName("사다리 타기 테스트")
    @ParameterizedTest(name = "사다리 타기 테스트 :: 시작 위치: {0}, 도착 위치: {1} ")
    @MethodSource(value = "ladderRideEntry")
    void findPosition_사다리타기테스트(Position source, Position dest) {
        /**
         * false |-----|     |
         * false |     |-----|
         * false |     |-----|
         */
        Line line1 = Line.valueOf(Bar.init(), Bar.valueOf(true), Bar.valueOf(false));
        Line line2 = Line.valueOf(Bar.init(), Bar.valueOf(false), Bar.valueOf(true));
        Line line3 = Line.valueOf(Bar.init(), Bar.valueOf(false), Bar.valueOf(true));

        Ladder ladder = Ladder.valueOf(line1, line2, line3);
        Position endPosition = ladder.findEndPosition(source);

        assertThat(endPosition).isEqualTo(dest);
    }
}
