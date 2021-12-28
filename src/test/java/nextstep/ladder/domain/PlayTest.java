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

    static LineStrategy strategy = new RandomStrategy();

    @ParameterizedTest
    @DisplayName("test")
    @MethodSource("provideLines")
    void create(Lines lines) {
        Users users = Users.createByString(UsersTest.NAMES);
        Results results = Results.createByString(ResultsTest.RESULTS);

        Ladder ladder = new Ladder(lines);
        Play play = new Play(ladder, users, results);
        Result jk = play.getResults(new User(Name.of("jk")));
        assertThat(jk.getValue()).isEqualTo("꽝");

        Result honux = play.getResults(new User(Name.of("honux")));
        assertThat(honux.getValue()).isEqualTo("5000");
    }

    private static Stream<Arguments> provideLines() {
        return Stream.of(
            Arguments.of(new Lines(Arrays.asList(
                new Line(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false)), strategy),
                new Line(Arrays.asList(new Point(false, false), new Point(false, true), new Point(true, false), new Point(false, false)), strategy),
                (new Line(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false)), strategy))))));
    }
}