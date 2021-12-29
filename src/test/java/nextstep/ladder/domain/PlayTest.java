package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class PlayTest {

    @ParameterizedTest
    @DisplayName("create")
    @MethodSource("provideLines")
    void create(Lines lines) {
        Users users = Users.createByString(UsersTest.NAMES);
        Results results = Results.createByString(ResultsTest.RESULTS);

        Ladder ladder = Ladder.of(lines);
        Play play = new Play(ladder, users);
        Result jk = results.getResult(play, new User(Name.of("jk")));
        assertThat(jk.getValue()).isEqualTo("꽝");

        Result honux = results.getResult(play, new User(Name.of("honux")));
        assertThat(honux.getValue()).isEqualTo("5000");
    }

    static Stream<Arguments> provideLines() {
        return Stream.of(
            Arguments.of(Lines.of(Arrays.asList(
                Line.of(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false))),
                Line.of(Arrays.asList(new Point(false, false), new Point(false, true), new Point(true, false), new Point(false, false))),
                (Line.of(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false))))))));
    }
}