package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author han
 */
class LadderTest {

    @Test
    void create() {
        Users users = Users.createByString(UsersTest.NAMES);
        Height height = new Height(5);
        Results results = Results.createByString(ResultsTest.RESULTS);
        assertDoesNotThrow(() -> Ladder.from(users, height, results));
    }

    @ParameterizedTest
    @DisplayName("test")
    @MethodSource("provideLines")
    void toPlay(Lines lines) {
        Users users = Users.createByString(UsersTest.NAMES);
        Results results = Results.createByString(ResultsTest.RESULTS);

        Ladder ladder = new Ladder(users, lines, results);
        List<Position> positions = ladder.toPlay();
        assertThat(positions.get(0).getUser().getName()).isEqualTo("jk");
        assertThat(positions.get(1).getUser().getName()).isEqualTo("honux");
        assertThat(positions.get(2).getUser().getName()).isEqualTo("crong");
        assertThat(positions.get(3).getUser().getName()).isEqualTo("pobi");
    }

    private static Stream<Arguments> provideLines() {
        return Stream.of(
            Arguments.of(new Lines(Arrays.asList(
                new Line(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false))),
                new Line(Arrays.asList(new Point(false, false), new Point(false, true), new Point(true, false), new Point(false, false))),
                (new Line(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false))))))));
    }
}