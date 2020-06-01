package nextstep.ladder;

import nextstep.ladder.domain.RandomBridgeGenerator;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderGame createLadderGame(List<String> names, int height) {
        LadderRequestDto ladderRequestDto = this.createLadderRequestDto(names, height);
        return new LadderGame(ladderRequestDto, new RandomBridgeGenerator(new Random()));
    }

    private LadderRequestDto createLadderRequestDto(List<String> names, int height) {
        return new LadderRequestDto(names, height);
    }

    @ParameterizedTest
    @MethodSource("provideLadderInformation")
    @DisplayName("사다리 게임 생성 테스트")
    void createLadderGameTest(List<String> names, int height) {
        LadderGame ladderGame = this.createLadderGame(names, height);
        LadderResultDto ladderResultDto = ladderGame.getLadderResult();
        List<String> playerNames = ladderResultDto.getPlayers()
                .stream()
                .map(player -> player.getName())
                .collect(Collectors.toList());
        assertThat(ladderResultDto.getPlayers()).hasSize(names.size());
        assertThat(playerNames).isEqualTo(names);
        assertThat(ladderResultDto.getLines()).hasSize(height);
    }

    private static Stream<Arguments> provideLadderInformation() {
        return Stream.of(
                Arguments.of(Arrays.asList("il", "il2"), 5),
                Arguments.of(Arrays.asList("il", "il2", "i3"), 3),
                Arguments.of(Arrays.asList("il", "il2"), 6),
                Arguments.of(Arrays.asList("il", "il2", "il3", "il4"), 4)
        );
    }
}
