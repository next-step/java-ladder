package ladder.domain;

import ladder.domain.ladder.Position;
import ladder.domain.ladder.Positions;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.fixture.PlayerAndPrizeFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersAndPrizesTest {

    private Players players;
    private Prizes prizes;

    @BeforeEach
    void setUp() {
        players = PlayerAndPrizeFixtures.of().getPlayers();
        prizes = PlayerAndPrizeFixtures.of().getPrizes();
    }

    @DisplayName("Players null 인 경우 예외 반환")
    @NullSource
    @ParameterizedTest
    void playersIsNull(final Players players) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PlayersAndPrizes.valueOf(players, prizes));
    }

    @DisplayName("Prizes null 인 경우 예외 반환")
    @NullSource
    @ParameterizedTest
    void prizesIsNull(final Prizes prizes) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PlayersAndPrizes.valueOf(players, prizes));
    }

    @DisplayName("PlayersAndPrizes 생성 실패 : - 게임 참여자의 수와 게임 실행 결과의 수가 다른 경우")
    @Test
    void notEqualsCountWithPlayersAndPrizes() {
        Prizes prizes = Prizes.of(Arrays.asList("3000", "꽝", "5000"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> PlayersAndPrizes.valueOf(players, prizes));
    }

    @DisplayName("사타리 타기 실행 결과에 따라 Player 에 매칭되는 Prize 를 Map 의 형태로 반환")
    @ParameterizedTest
    @MethodSource
    void matchPlayerAndPrize(final Positions prizePositions) {
        PlayersAndPrizes playersAndPrizes = PlayersAndPrizes.valueOf(players, prizes);
        Map<Player, Prize> matchResult = playersAndPrizes.matchPlayerAndPrize(prizePositions);

        IntStream.range(0, playersAndPrizes.getPlayersCount())
                .forEach(index -> assertThat(matchResult.get(Player.of(playersAndPrizes.getPlayerNames().get(index))))
                                    .isEqualTo(prizes.indexOf(prizePositions.indexOf(Position.of(index))))
                );
    }

    private static Stream<Arguments> matchPlayerAndPrize() {
        return Stream.of(
                Arguments.of(Positions.of(
                        Arrays.asList(
                                Position.of(0), Position.of(1), Position.of(2), Position.of(3), Position.of(4))),
                        Arrays.asList(
                                Position.of(1), Position.of(0), Position.of(4), Position.of(3), Position.of(2)))
        );
    }

    @DisplayName("Players 의 모든 이름을 반환")
    @Test
    void getPlayerNames() {
        assertThat(PlayersAndPrizes.valueOf(players, prizes).getPlayerNames())
                .isEqualTo(PlayerAndPrizeFixtures.playerNames);
    }

    @DisplayName("Prizes 의 모든 이름을 반환")
    @Test
    void getPrizeNames() {
        assertThat(PlayersAndPrizes.valueOf(players, prizes).getPrizeNames())
                .isEqualTo(PlayerAndPrizeFixtures.prizeNames);
    }

    @DisplayName("Players 의 개수 반환")
    @Test
    void getPlayersCount() {
        assertThat(PlayersAndPrizes.valueOf(players, prizes).getPlayersCount())
                .isEqualTo(players.count());
    }

    @DisplayName("Prizes 의 개수 반환")
    @Test
    void getPrizesCount() {
        assertThat(PlayersAndPrizes.valueOf(players, prizes).getPrizesCount())
                .isEqualTo(prizes.count());
    }
}
