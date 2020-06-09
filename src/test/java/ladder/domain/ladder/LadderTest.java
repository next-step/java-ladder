package ladder.domain.ladder;

import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    private Players players;
    private Prizes prizes;

    private static LadderShapeInfo shapeInfoOfSinglePlayer;
    private static LadderShapeInfo shapeInfoOfMultiplePlayers;

    @BeforeEach
    void setUp() {
        List<String> singlePlayerName = Collections.singletonList("heee");
        Players singlePlayer = Players.of(singlePlayerName);

        List<String> singlePrizeName = Collections.singletonList("win");
        Prizes singlePrize = Prizes.of(singlePrizeName);

        shapeInfoOfSinglePlayer = LadderShapeInfo.valueOf(
                singlePlayer, singlePrize, Height.of(Height.MIN_HEIGHT));

        List<String> names = Arrays.asList("pobi", "honux");
        this.players = Players.of(names);

        List<String> prizeNames = Arrays.asList("3000", "꽝");
        this.prizes = Prizes.of(prizeNames);

        shapeInfoOfMultiplePlayers = LadderShapeInfo.valueOf(
                players, prizes, Height.of(Height.MIN_HEIGHT * 5));
    }

    @DisplayName("사다리 생성 실패: 사다리의 높이가 1보다 작은 경우")
    @Test
    void createFailureByHeightLessThanMin() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(
                        LadderShapeInfo.valueOf(players, prizes, Height.of(Height.MIN_HEIGHT - 1))));
    }

    @DisplayName("사다리 생성 실패: 참여자의 수 1보다 작은 경우")
    @Test
    void createFailureByPlayersLessThanMin() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(
                        LadderShapeInfo.valueOf(Players.of(new ArrayList<>()), prizes, Height.of(Height.MIN_HEIGHT))));
    }

    @DisplayName("Ladder 생성")
    @Test
    void create() {
        assertThatCode(() -> Ladder.of(shapeInfoOfSinglePlayer))
                .doesNotThrowAnyException();
    }

    @DisplayName("한 명의 사용자가 사다리를 타면 index 0 의 prize 리스트를 반환")
    @Test
    void rideWithSinglePlayer() {
        Ladder ladder = Ladder.of(shapeInfoOfSinglePlayer);

        assertThat(ladder.ride().size())
                .isEqualTo(shapeInfoOfSinglePlayer.getPrizes().count());
    }

    @DisplayName("모든 사용자가 사다리를 타고 난 결과에 대한 prize index 리스트를 반환")
    @Test
    void rideWithMultiplePlayers() {
        Ladder ladder = Ladder.of(shapeInfoOfMultiplePlayers);

        assertThat(ladder.ride().size())
                .isEqualTo(shapeInfoOfMultiplePlayers.getPrizes().count());
    }
}
