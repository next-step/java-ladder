package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderGameTest {

    private static final String PLAYER1_NAME = "more";
    private static final String PLAYER2_NAME = "much";
    private static final Position POSITION_ZERO = new Position(0);
    private static final Position POSITION_ONE = new Position(1);
    private static final Player PLAYER1 = new Player(PLAYER1_NAME, POSITION_ZERO);
    private static final Player PLAYER2 = new Player(PLAYER2_NAME, POSITION_ONE);
    private static final Players PLAYERS = new Players(List.of(PLAYER1, PLAYER2));
    private static final List<String> RESULTS = List.of("당첨", "꽝");
    private static final LadderGame LADDER_GAME = new LadderGame(PLAYERS, RESULTS);

    @DisplayName("LadderGame의 players 메서드는 Players 객체를 반환한다")
    @Test
    void players() {
        // when
        Players players = LADDER_GAME.players();

        // then
        Assertions.assertThat(players).isEqualTo(PLAYERS);
    }

    @DisplayName("LadderGame의 results 메서드는 결과 목록을 반환한다")
    @Test
    void results() {
        // when
        List<String> results = LADDER_GAME.results();

        // then
        Assertions.assertThat(results).isEqualTo(RESULTS);
    }

    @DisplayName("LadderGame의 play 메서드는 사다리 게임 결과를 반환한다")
    @Test
    void play() {
        // given
        List<Boolean> points = List.of(false);
        LadderLine ladderLine = new LadderLine(points);
        Ladder ladder = new Ladder(List.of(ladderLine));

        // when
        LadderGameResult result = LADDER_GAME.play(ladder);

        // then
        Player resultPlayer = result.findPlayer(PLAYER1_NAME);
        Assertions.assertThat(resultPlayer.result()).isEqualTo("당첨");
        Assertions.assertThat(resultPlayer.getPosition()).isEqualTo(POSITION_ZERO);
    }

    @DisplayName("LadderGame의 play 메서드는 사다리를 통해 위치를 변경한다")
    @Test
    void playWithMovement() {
        // given
        List<Boolean> points = List.of(true);
        LadderLine ladderLine = new LadderLine(points);
        Ladder ladder = new Ladder(List.of(ladderLine));

        // when
        LadderGameResult result = LADDER_GAME.play(ladder);

        // then
        Player resultPlayer = result.findPlayer(PLAYER1_NAME);
        Assertions.assertThat(resultPlayer.result()).isEqualTo("꽝");
        Assertions.assertThat(resultPlayer.getPosition()).isEqualTo(POSITION_ONE);
    }
}
