package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LinesTest {

    @DisplayName("사다리 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideLadder")
    void lineConstructorTest(final List<String> userNames, final List<String> executionResults, final Integer height, final Ladder expected) {
        Ladder ladder = Ladder.of(userNames, executionResults, height);

        Players players = ladder.getPlayers();
        Lines lines = ladder.getLines();

        Integer resultPlayerSize = players.getPlayers().size();
        Integer resultLadderSize = lines.getLines().size();


        Players expectedPlayers = expected.getPlayers();
        Lines expectedLines = expected.getLines();


        Integer expectedPlayerSize = expectedPlayers.getPlayers().size();
        Integer expectedLaddersSize = expectedLines.getLines().size();

        assertThat(resultPlayerSize).isEqualTo(expectedPlayerSize);
        assertThat(resultLadderSize).isEqualTo(expectedLaddersSize);
    }

    private static Stream<Arguments> provideLadder() {
        return Stream.of(
                Arguments.of(Arrays.asList("aaa", "bbb", "ccc"), Arrays.asList("a", "b", "c"), 5, Ladder.of(Arrays.asList("aaa", "bbb", "ccc"), Arrays.asList("a", "b", "c"), 5)),
                Arguments.of(Arrays.asList("aaa", "bbb"), Arrays.asList("a", "b"), 2, Ladder.of(Arrays.asList("aaa", "bbb"), Arrays.asList("a", "b"), 2))
        );
    }
}
