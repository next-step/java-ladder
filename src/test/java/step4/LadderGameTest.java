package step4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.ladder.*;
import step4.domain.ladder.dto.LadderResultDTO;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    @DisplayName("사다리게임 진행 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderGameInfo")
    void playLadderGame(Ladder ladder, LadderPlayers players, LadderResults ladderResults) {
        Player player = players.pick("a");
        Point resultPoint = LadderGame.play(player, ladder);

        LadderResultDTO ladderResultDTO = ladderResults.resultByPoint(resultPoint.getX());

        assertThat(ladderResultDTO.getResult()).isEqualTo("5000");

    }

    @DisplayName("사다리에게임 없는 유저 선택 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderGameInfo")
    void playLadderGameFromNotExistsPlayer(Ladder ladder, LadderPlayers players, LadderResults ladderResults) {

        assertThatThrownBy(() -> {
            players.pick("g");
        }).isInstanceOf(NoSuchElementException.class);

    }

    private static Stream<Arguments> provideLadderGameInfo() {
        LadderPlayers players = LadderGame.join("a,b,c,d,e");
        LadderResults ladderResults = LadderResults.of("꽝,5000,꽝,3000,10000");

        List<Line> lines = Arrays.asList(
                Line.of(Arrays.asList(true, false, true, false)),
                Line.of(Arrays.asList(false, false, false, false)),
                Line.of(Arrays.asList(true, false, false, true)),
                Line.of(Arrays.asList(true, false, false, true))
        );
        Ladder ladder = new Ladder(new LadderLine(lines));

        return Stream.of(
                Arguments.of(ladder, players, ladderResults)
        );
    }

}
