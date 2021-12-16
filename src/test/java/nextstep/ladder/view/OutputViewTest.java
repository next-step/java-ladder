package nextstep.ladder.view;

import java.util.stream.Stream;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.TestLineStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static nextstep.ladder.domain.LineTest.l;
import static nextstep.ladder.domain.NameTest.n;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    static Stream<Arguments> parseName() {
        return Stream.of(
                Arguments.of(n("name1"), " name1"),
                Arguments.of(n("name"), "  name"),
                Arguments.of(n(" "), "      ")
        );
    }

    @ParameterizedTest(name = "format name: {arguments}")
    @MethodSource("parseName")
    public void formatName(Name name, String expected) {
        assertThat(OutputView.formatName(name)).isEqualTo(expected);
    }


    static Stream<Arguments> parseFormatLine() {
        return Stream.of(
                Arguments.of(l(3, TestLineStrategy.NO_LINE_STRATEGY), "     |     |     |"),
                Arguments.of(l(3, TestLineStrategy.ALL_LINE_STRATEGY), "     |-----|-----|")
        );
    }

    @ParameterizedTest(name = "format line: {arguments}")
    @MethodSource("parseFormatLine")
    public void formatLine(Line line, String expected) {
        assertThat(OutputView.formatLine(line)).isEqualTo(expected);
    }

    static Stream<Arguments> parseMapLine() {
        return Stream.of(
                Arguments.of(l(3, TestLineStrategy.NO_LINE_STRATEGY), "     |     "),
                Arguments.of(l(3, TestLineStrategy.ALL_LINE_STRATEGY), "-----|-----")
        );
    }

    @ParameterizedTest(name = "map line: {arguments}")
    @MethodSource("parseMapLine")
    public void mapLine(Line line, String expected) {
        assertThat(OutputView.mapLine(line)).isEqualTo(expected);
    }


    @ParameterizedTest(name = "map points: {arguments}")
    @ValueSource(strings = "-")
    public void mapLine(String input) {
        assertThat(OutputView.mapPoint(input.equals("-"))).isEqualTo(input.repeat(5));
    }

}
