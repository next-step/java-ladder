package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.utils.LineMaker.makeLine;
import static nextstep.ladder.utils.PositionMaker.makePosition;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(new TestLinesGenerator(), 5, 5);
    }

    @ParameterizedTest(name = "TestLinesGenerator 클래스는 각 행별로 width - 1, width 에 해당하는 라인을 생성한다. " +
            "즉 위에 ladder 클래스로는 3열과 4열에 해당하는 라인이 각 행마다 존재해야한다.")
    @MethodSource("positionMoveArgument")
    void 생성_라인_검증(Line line) {
        assertThat(ladder.hasLine(line)).isTrue();
    }

    static Stream<Arguments> positionMoveArgument() {
        return Stream.of(
                Arguments.arguments(makeLine(3,0,4,0)),
                Arguments.arguments(makeLine(3,1,4,1)),
                Arguments.arguments(makeLine(3,2,4,2)),
                Arguments.arguments(makeLine(3,3,4,3)),
                Arguments.arguments(makeLine(3,4,4,4))
        );
    }

    @ParameterizedTest(name = "사다리는 파라미터로 전달된 height 만큼 높이가 생성되 있어야 한다.")
    @CsvSource(value = {
            "3|3",
            "4|4",
            "5|5",
            "6|6",
    }, delimiter = '|')
    void 높이_검증(int width, int height) {
        assertThat(new Ladder(new TestLinesGenerator(), width, height).height()).isEqualTo(height);
    }

    @ParameterizedTest(name = "사다리 이동 위치검증 테스트로 Position정보를 넘기면 사다리에 존재하는" +
            "라인을 타고 사다리 높이만큼 이동한 Position을 리턴한다." +
            "TestLinesGenerator 클래스는 각 행별로 width - 1, width 에 해당하는 라인을 생성하므로" +
            "3|0, 4|0에 해당하는 Position만 가로위치가 변경되고 나머지는 가로위치가 그대로인 상태로" +
            "높이만 변경된다.")
    @CsvSource(value = {
            "0|0|0|5",
            "1|0|1|5",
            "2|0|2|5",
            "3|0|4|5",
            "4|0|3|5"
    }, delimiter = '|')
    void 사다리_이동_결과_검증(int x, int y, int next_x, int next_y) {
        assertThat(ladder.move(makePosition(x,y))).isEqualTo(makePosition(next_x,next_y));
    }

}