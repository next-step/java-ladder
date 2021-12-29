package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class ResultsTest {

    static final String RESULTS = "꽝,5000,꽝,3000";

    @Test
    void createByString() {
        Results results = Results.createByString(RESULTS);
        assertThat(results.getResult().size()).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("getResult")
    @MethodSource("nextstep.ladder.domain.PlayTest#provideLines")
    void getResultBy(Lines lines) {
        Users users = Users.createByString(UsersTest.NAMES);
        Results results = Results.createByString(ResultsTest.RESULTS);

        Ladder ladder = Ladder.of(lines);
        Play play = new Play(ladder, users);
        Result jk = results.getResult(play, new User(Name.of("jk")));
        assertThat(jk.getValue()).isEqualTo("꽝");
    }
}