package step2;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @TestFactory
    Stream<DynamicTest> 사다리_결과에_대한_예외() {
        return Stream.of(
                DynamicTest.dynamicTest("null이면 예외", () -> {
                    assertThatThrownBy(() -> {
                        Results.newResults(null, null);
                    }).isInstanceOf(IllegalArgumentException.class);
                }),
                DynamicTest.dynamicTest("참가자 수와 다르면면 예외", () -> {
                    assertThatThrownBy(() -> {
                        Results.newResults("1000,2000,꽝", Players.newPlayers("박효신,김범수,이병덕,나얼"));
                    }).isInstanceOf(IllegalArgumentException.class);
                })
        );
    }

    @Test
    void 사다리_결과_생성() {
        // given
        Results expectResults = new Results(Arrays.asList(Result.newResult("1000"), Result.newResult("2000"), Result.newResult("꽝")));

        // when
        Results results = Results.newResults("1000,2000,꽝", Players.newPlayers("박효신,김범수,이병덕"));

        // then
        assertThat(results.getResults()).isEqualTo(expectResults.getResults());
    }
}