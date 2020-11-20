package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.ladder.*;
import step3.domain.ladder.dto.LadderBuildDTO;
import step3.strategy.MakeLadderLineStrategy;

import java.util.stream.Stream;

public class LadderGameTest {

    @DisplayName("사다리게임 진행 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderGameInfo")
    void playLadderGame(LadderPlayers players, int lineHeight, LadderResults ladderResults) {
        Ladder ladder = LadderGame.makeLadder(new LadderBuildDTO(players, lineHeight), new MakeLadderLineStrategy());
        Player player = players.pick("crong");
        Point resultPoint = LadderGame.play(player, ladder);
    }

    private static Stream<Arguments> provideLadderGameInfo() {
        LadderPlayers players = LadderGame.join("crong,pobi,kiki,bobi");
        LadderResults ladderResults = LadderResults.of("꽝,5000,꽝,3000");

        return Stream.of(
                Arguments.of(players, 5, ladderResults)
        );
    }

}
