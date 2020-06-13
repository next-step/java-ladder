package ladder.domain.ladder.shape;

import ladder.domain.PlayersAndPrizes;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import ladder.fixture.PlayerAndPrizeFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LadderShapeInfoTest {

    private PlayersAndPrizes playersAndPrizes;
    private Height height;

    @BeforeEach
    void setUp() {
        this.playersAndPrizes = PlayerAndPrizeFixtures.of().getMultiplePlayersAndPrizes();
        this.height = Height.of(5);
    }

    @DisplayName("LadderShapeInfo 생성")
    @Test
    void create() {
        assertThatCode(() -> LadderShapeInfo.valueOf(playersAndPrizes, height))
                .doesNotThrowAnyException();
    }

    @DisplayName("LadderShapeInfo 생성 실패 : playersAndPrizes 가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final PlayersAndPrizes playersAndPrizes) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo.valueOf(playersAndPrizes, height));
    }

    @DisplayName("LadderShapeInfo 생성 실패 : 사다리 높이가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final Height height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo.valueOf(playersAndPrizes, height));
    }

    @DisplayName("LadderShapeInfo 생성 실패 : - 게임 참여자의 수와 게임 실행 결과의 수가 다른 경우")
    @Test
    void notEqualsCountWithPlayersAndPrizes() {
        Players players = PlayerAndPrizeFixtures.of().getPlayers();
        Prizes prizes = Prizes.of(Arrays.asList("3000", "꽝", "5000"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo.valueOf(
                        PlayersAndPrizes.valueOf(players, prizes), height));
    }

    @DisplayName("입력한 참여자와 게임 결과를 반환")
    @Test
    void getPlayers() {
        assertThat(LadderShapeInfo.valueOf(playersAndPrizes, height)
                .getPlayersAndPrizes().getPlayerNames())
                .isEqualTo(PlayerAndPrizeFixtures.playerNames);
    }

    @DisplayName("입력한 참여자와 게임 결과를 반환")
    @Test
    void getPrizes() {
        assertThat(LadderShapeInfo.valueOf(playersAndPrizes, height)
                .getPlayersAndPrizes().getPrizeNames())
                .isEqualTo(PlayerAndPrizeFixtures.prizeNames);
    }

    @DisplayName("입력한 사다리의 높이를 반환")
    @Test
    void getHeight() {
        assertThat(LadderShapeInfo.valueOf(playersAndPrizes, height).getHeight())
                .isEqualTo(height.getValue());
    }

    @DisplayName("사다리의 한 행에 있는 기둥의 수를 반환")
    @Test
    void getWidth() {
        assertThat(LadderShapeInfo.valueOf(playersAndPrizes, height).getWidth().getValue())
                .isEqualTo(playersAndPrizes.getPlayersCount());
    }
}
