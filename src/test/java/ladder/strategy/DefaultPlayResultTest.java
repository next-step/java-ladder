package ladder.strategy;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;
import ladder.generator.DefaultLadderGenerator;
import ladder.generator.DefaultLineGenerator;
import ladder.generator.LadderGenerator;
import ladder.generator.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultPlayResultTest {

    @ParameterizedTest
    @MethodSource("provideIndexValue")
    @DisplayName("사다리 게힘 실행 시, 모든 결과항목 반환 - 결과에 맞는 항목들 Map 으로 반환")
    void createAllResults(String name, String expectedItem) {
        LadderPlayers players = new LadderPlayers(Arrays.asList("pobi", "honux", "crong"));
        LineGenerator lineGenerator = new DefaultLineGenerator(() -> true);
        LadderHeight height = new LadderHeight(3);
        LadderGenerator generator = new DefaultLadderGenerator(lineGenerator, height);
        Ladder ladder = generator.generate(players.size());
        ExecutionResults items = new ExecutionResults(Arrays.asList("꽝", "5000", "10000"));

        PlayResult result = new DefaultPlayResult(ladder);
        Map<String, String> results = result.play(players, items);

        assertThat(results).size().isEqualTo(3);
        assertThat(results.get(name)).isEqualTo(expectedItem);
        assertThat(results.get(name)).isEqualTo(expectedItem);
    }

    private static Stream<Arguments> provideIndexValue() {
        return Stream.of(
                Arguments.of("pobi", "5000"),
                Arguments.of("honux", "꽝"),
                Arguments.of("crong", "10000")
        );
    }

}