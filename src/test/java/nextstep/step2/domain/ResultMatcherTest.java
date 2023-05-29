package nextstep.step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static nextstep.step2.domain.LadderTest.createDefaultLadder;
import static org.assertj.core.api.Assertions.assertThat;

class ResultMatcherTest {

    @ParameterizedTest
    @CsvSource({"a,1000", "b,꽝", "c,2000"})
    void 사다리게임에서_참여자의_결과를_반환한다(String name, String expected) {
        final var ladder = createDefaultLadder();
        final var result = createResult();
        final var matcher = new ResultMatcher(ladder, result);

        final var actual = matcher.match(name);

        assertThat(actual).isEqualTo(expected);
    }

    private Result createResult() {
        return new Result(List.of("1000", "꽝", "2000"));
    }

}
