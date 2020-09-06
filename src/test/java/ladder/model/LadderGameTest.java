package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private static Stream<Arguments> provideForPlay() {
        return Stream.of(
                Arguments.of(Arrays.asList("a", "b", "c"), 3,
                             Arrays.asList("b", "a", "c")),
                Arguments.of(Arrays.asList("a", "b", "c", "d"), 5,
                             Arrays.asList("b", "a", "d", "c")),
                Arguments.of(Arrays.asList("a", "b"), 6,
                        Arrays.asList("a", "b"))

        );
    }

    @ParameterizedTest
    @MethodSource("provideForPlay")
    @DisplayName("사다리 타기 게임 테스트")
    void play(List<String> userNames, int height, List<String> expectedUserNames) {
        // given
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;
        LadderGame ladderGame = LadderGame.of(userNames, height, alwaysGenerateStrategy);

        // when
        ladderGame.play();

        // then
        assertThat(ladderGame.getUsersName()).isEqualTo(expectedUserNames);
    }

}
