package nextstep.ladder.step4.domain.ladder;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import nextstep.ladder.step4.domain.ladder.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void play(int width) {
        List<DefaultLine> lines = new ArrayList<>();
        lines.add(new DefaultLineGenerator(new RandomLineStrategy()).generate(width));
        lines.add(new DefaultLineGenerator(new RandomLineStrategy()).generate(width));

        assertThat(new DefaultLadder(width, lines).play()).isInstanceOf(LadderResult.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    @DisplayName("사다리 생성")
    void create(int width) {
        List<DefaultLine> lines = new ArrayList<>();
        lines.add(new DefaultLineGenerator(new RandomLineStrategy()).generate(width));

        assertThat(new DefaultLadder(width, lines)).isInstanceOf(DefaultLadder.class);
    }

    @Test
    @DisplayName("lines 가 비어있을 시 예외처리")
    void exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new DefaultLadder(3, new ArrayList<>()));
    }

    @ParameterizedTest
    @MethodSource("generate")
    @DisplayName("실행결과 pobi 테스트")
    void pobi(DefaultLadder ladder) {
        LadderResult ladderResult = ladder.play();
        assertThat(ladderResult.get(0)).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("generate")
    @DisplayName("실행결과 honux 테스트")
    void honux(DefaultLadder ladder) {
        LadderResult ladderResult = ladder.play();
        assertThat(ladderResult.get(1)).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("generate")
    @DisplayName("실행결과 crong 테스트")
    void crong(DefaultLadder ladder) {
        LadderResult ladderResult = ladder.play();
        assertThat(ladderResult.get(2)).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("generate")
    @DisplayName("실행결과 jk 테스트")
    void jk(DefaultLadder ladder) {
        LadderResult ladderResult = ladder.play();
        assertThat(ladderResult.get(3)).isEqualTo(1);
    }

    static Stream<Arguments> generate() {
        List<DefaultLine> ladder = new ArrayList<>();

        List<Point> line1 = new ArrayList<>();
        line1.add(new Point(0, Direction.first(TRUE)));
        line1.add(new Point(1, Direction.first(TRUE).next(FALSE)));
        line1.add(new Point(2, Direction.first(TRUE)));
        line1.add(new Point(3, Direction.first(TRUE).last()));
        ladder.add(new DefaultLine(line1));

        List<Point> line2 = new ArrayList<>();
        line2.add(new Point(0, Direction.first(FALSE)));
        line2.add(new Point(1, Direction.first(TRUE)));
        line2.add(new Point(2, Direction.first(TRUE).last()));
        line2.add(new Point(3, Direction.first(FALSE)));
        ladder.add(new DefaultLine(line2));

        List<Point> line3 = new ArrayList<>();
        line3.add(new Point(0, Direction.first(TRUE)));
        line3.add(new Point(1, Direction.first(TRUE).last()));
        line3.add(new Point(2, Direction.first(FALSE)));
        line3.add(new Point(3, Direction.first(FALSE)));
        ladder.add(new DefaultLine(line3));

        List<Point> line4 = new ArrayList<>();
        line4.add(new Point(0, Direction.first(FALSE)));
        line4.add(new Point(1, Direction.first(TRUE)));
        line4.add(new Point(2, Direction.first(TRUE).last()));
        line4.add(new Point(3, Direction.first(FALSE)));
        ladder.add(new DefaultLine(line4));

        List<Point> line5 = new ArrayList<>();
        line5.add(new Point(0, Direction.first(TRUE)));
        line5.add(new Point(1, Direction.first(TRUE).last()));
        line5.add(new Point(2, Direction.first(TRUE)));
        line5.add(new Point(3, Direction.first(TRUE).last()));
        ladder.add(new DefaultLine(line5));

        return Stream.of(Arguments.of(new DefaultLadder(4, ladder)));
    }

}
