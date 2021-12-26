package nextstep.ladder.view;

import java.util.stream.Stream;

import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.engine.Line;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static nextstep.ladder.domain.LadderLineTest.ll;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static nextstep.ladder.domain.TestLadderPointStrategy.ALL_LINE_STRATEGY;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    static Stream<Arguments> parseName() {
        return Stream.of(
                Arguments.of(pn("name1"), " name1"),
                Arguments.of(pn("name"), "  name"),
                Arguments.of(pn(" "), "      ")
        );
    }

    @ParameterizedTest(name = "format name: {arguments}")
    @MethodSource("parseName")
    public void formatName(PlayerName name, String expected) {
        assertThat(OutputView.formatName(name)).isEqualTo(expected);
    }


    static Stream<Arguments> parseFormatLine() {
        return Stream.of(
                Arguments.of(ll(2, NO_LINE_STRATEGY), "     |     |     "),
                Arguments.of(ll(2, ALL_LINE_STRATEGY), "     |-----|     ")
        );
    }

    @ParameterizedTest(name = "format line: {arguments}")
    @MethodSource("parseFormatLine")
    public void formatLine(Line line, String expected) {
        assertThat(OutputView.formatLine(line)).isEqualTo(expected);
    }

    static Stream<Arguments> parseMapLine() {
        return Stream.of(
                Arguments.of(ll(2, NO_LINE_STRATEGY), "     |     "),
                Arguments.of(ll(2, ALL_LINE_STRATEGY), "-----|     ")
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
