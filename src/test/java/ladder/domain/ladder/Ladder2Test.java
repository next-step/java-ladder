package ladder.domain.ladder;

import ladder.domain.PlayersAndPrizes;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo2;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

public class Ladder2Test {

    private PlayersAndPrizes singlePlayersAndPrizes;
    private PlayersAndPrizes multiplePlayersAndPrizes;

    private static LadderShapeInfo2 shapeInfoOfSinglePlayer;
    private static LadderShapeInfo2 shapeInfoOfMultiplePlayers;

    @BeforeEach
    void setUp() {
        Players singlePlayer = Players.of(Collections.singletonList("heee"));
        Prizes singlePrize = Prizes.of(Collections.singletonList("win"));
        this.singlePlayersAndPrizes = PlayersAndPrizes.valueOf(singlePlayer, singlePrize);

        shapeInfoOfSinglePlayer = LadderShapeInfo2.valueOf(
                singlePlayersAndPrizes, Height.of(Height.MIN_HEIGHT));

        Players players = Players.of(Arrays.asList("pobi", "honux"));
        Prizes prizes = Prizes.of(Arrays.asList("3000", "꽝"));
        this.multiplePlayersAndPrizes = PlayersAndPrizes.valueOf(players, prizes);

        shapeInfoOfMultiplePlayers = LadderShapeInfo2.valueOf(
                multiplePlayersAndPrizes, Height.of(Height.MIN_HEIGHT * 5));
    }

    @DisplayName("사다리 생성 실패: 사다리의 높이가 1보다 작은 경우")
    @Test
    void createFailureByHeightLessThanMin() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder2.of(
                        LadderShapeInfo2.valueOf(multiplePlayersAndPrizes, Height.of(Height.MIN_HEIGHT - 1))));
    }

    @DisplayName("사다리 생성 실패: PlayersAndPrizes 가 null 인 경우")
    @Test
    void createFailureByPlayersLessThanMin() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder2.of(
                        LadderShapeInfo2.valueOf(null, Height.of(Height.MIN_HEIGHT))));
    }

    @DisplayName("Ladder 생성")
    @Test
    void create() {
        assertThatCode(() -> Ladder2.of(shapeInfoOfSinglePlayer))
                .doesNotThrowAnyException();
    }

    @DisplayName("한 명의 사용자가 사다리를 타면 index 0 의 prize 리스트를 반환")
    @Test
    void rideWithSinglePlayer() {
        Ladder2 ladder = Ladder2.of(shapeInfoOfSinglePlayer);

        assertThat(ladder.ride().size())
                .isEqualTo(shapeInfoOfSinglePlayer.getPlayersAndPrizes().getPrizesCount());
    }

    @DisplayName("모든 사용자가 사다리를 타고 난 결과에 대한 prize index 리스트를 반환")
    @Test
    void rideWithMultiplePlayers() {
        Ladder2 ladder = Ladder2.of(shapeInfoOfMultiplePlayers);

        assertThat(ladder.ride().size())
                .isEqualTo(shapeInfoOfMultiplePlayers.getPlayersAndPrizes().getPrizesCount());
    }
}
