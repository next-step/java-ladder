package ladder.strategy;

import ladder.domain.dto.LadderInfoDto;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.user.LadderPlayers;
import ladder.domain.user.PlayerName;
import ladder.generator.DefaultLadderGenerator;
import ladder.generator.DefaultLineGenerator;
import ladder.generator.LadderGenerator;
import ladder.generator.LineGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultPlayResultTest {

    LadderInfoDto infoDto;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        infoDto = new LadderInfoDto(Arrays.asList("pobi", "honux", "crong"), Arrays.asList("꽝", "5000", "10000"), 3);
        LadderPlayers ladderPlayers = infoDto.getLadderPlayers();
        LadderHeight height = infoDto.getHeight();
        LineGenerator lineGenerator = new DefaultLineGenerator(() -> true);
        LadderGenerator generator = new DefaultLadderGenerator(lineGenerator);
        ladder = generator.generate(ladderPlayers.size(), height);
    }

    @ParameterizedTest
    @MethodSource("provideIndexValue")
    @DisplayName("사다리 게힘 실행 시, 모든 결과항목 반환 - 결과에 맞는 항목들 Map 으로 반환")
    void createAllResults(PlayerName name, String expectedItem) {
        PlayResult result = new DefaultPlayResult();
        Map<PlayerName, String> results = result.play(ladder, infoDto);

        assertThat(results).size().isEqualTo(3);
        assertThat(results.get(name)).isEqualTo(expectedItem);
    }

    private static Stream<Arguments> provideIndexValue() {
        return Stream.of(
                Arguments.of(new PlayerName("pobi"), "5000"),
                Arguments.of(new PlayerName("honux"), "꽝"),
                Arguments.of(new PlayerName("crong"), "10000")
        );
    }

}