package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderTest {

    @DisplayName("사다리 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideLadder")
    void lineConstructorTest(final List<String> userNames, final Integer height, final Ladder expected) {
        Ladder ladder = Ladder.of(userNames, height);

        Integer resultPlayerSize = ladder.getPlayers().size();
        Integer resultLadderSize = ladder.getLadders().size();

        Integer expectedPlayerSize = expected.getPlayers().size();
        Integer expectedLaddersSize = expected.getLadders().size();

        assertThat(resultPlayerSize).isEqualTo(expectedPlayerSize);
        assertThat(resultLadderSize).isEqualTo(expectedLaddersSize);
    }

    private static Stream<Arguments> provideLadder() {
        return Stream.of(
                Arguments.of(Arrays.asList("aaa", "bbb", "ccc"), 5, Ladder.of(Arrays.asList("aaa", "bbb", "ccc"), 5)),
                Arguments.of(Arrays.asList("aaa", "bbb"), 2, Ladder.of(Arrays.asList("aaa", "bbb"), 2))
        );
    }
}
