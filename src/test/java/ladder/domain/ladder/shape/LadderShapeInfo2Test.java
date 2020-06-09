package ladder.domain.ladder.shape;

import ladder.domain.PlayersAndPrizes;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderShapeInfo2Test {

    private PlayersAndPrizes playersAndPrizes;
    private Height height;

    @BeforeEach
    void setUp() {
        List<String> names = Arrays.asList("pobi", "honux");
        List<String> prizeNames = Arrays.asList("3000", "꽝");

        this.playersAndPrizes = PlayersAndPrizes.valueOf(Players.of(names), Prizes.of(prizeNames));
        this.height = Height.of(5);
    }

    @DisplayName("LadderShapeInfo 생성")
    @Test
    void create() {
        assertThatCode(() -> LadderShapeInfo2.valueOf(playersAndPrizes, height))
                .doesNotThrowAnyException();
    }

    @DisplayName("LadderShapeInfo 생성 실패 : playersAndPrizes 가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final PlayersAndPrizes playersAndPrizes) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo2.valueOf(playersAndPrizes, height));
    }

    @DisplayName("LadderShapeInfo 생성 실패 : 사다리 높이가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final Height height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo2.valueOf(playersAndPrizes, height));
    }

    @DisplayName("LadderShapeInfo 생성 실패 : - 게임 참여자의 수와 게임 실행 결과의 수가 다른 경우")
    @Test
    void notEqualsCountWithPlayersAndPrizes() {
        Players players = Players.of(Arrays.asList("pobi", "honux"));
        Prizes prizes = Prizes.of(Arrays.asList("3000", "꽝", "5000"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo2.valueOf(
                        PlayersAndPrizes.valueOf(players, prizes), height));
    }

    @DisplayName("입력한 참여자와 게임 결과를 반환")
    @Test
    void getPlayers() {
        assertThat(LadderShapeInfo2.valueOf(playersAndPrizes, height)
                .getPlayersAndPrizes().getPlayerNames())
                .isEqualTo(Arrays.asList("pobi", "honux"));
    }

    @DisplayName("입력한 참여자와 게임 결과를 반환")
    @Test
    void getPrizes() {
        assertThat(LadderShapeInfo2.valueOf(playersAndPrizes, height)
                .getPlayersAndPrizes().getPrizeNames())
                .isEqualTo(Arrays.asList("3000", "꽝"));
    }

    @DisplayName("입력한 사다리의 높이를 반환")
    @Test
    void getHeight() {
        assertThat(LadderShapeInfo2.valueOf(playersAndPrizes, height).getHeight())
                .isEqualTo(height.getValue());
    }

    @DisplayName("사다리의 한 행에 있는 기둥의 수를 반환")
    @Test
    void getWidth() {
        assertThat(LadderShapeInfo2.valueOf(playersAndPrizes, height).getWidth().getValue())
                .isEqualTo(playersAndPrizes.getPlayersCount());
    }
}
