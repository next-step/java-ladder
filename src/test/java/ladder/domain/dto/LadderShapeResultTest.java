package ladder.domain.dto;

import ladder.domain.PlayersAndPrizes;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderShapeResultTest {

    private PlayersAndPrizes playersAndPrizes;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        Players players = Players.of(Arrays.asList("pobi", "honux"));
        Prizes prizes = Prizes.of(Arrays.asList("3000", "꽝"));
        this.playersAndPrizes = PlayersAndPrizes.valueOf(players, prizes);

        this.ladder = Ladder.of(
                LadderShapeInfo.valueOf(
                        playersAndPrizes, Height.of(5)),
                        new RandomStairGenerationStrategy());
    }

    @DisplayName("게임 참여자 이름과 사다리 판의 정보를 가진 LadderShapeResult 를 반환")
    @Test
    void create() {
        assertThatCode(() -> LadderShapeResult.of(playersAndPrizes, ladder))
                .doesNotThrowAnyException();
    }

    @DisplayName("인자로 넣은 게임 참여자의 정보를 반환")
    @Test
    void getPlayerNames() {
        assertThat(LadderShapeResult.of(playersAndPrizes, ladder)
                .getPlayerNames())
                .isEqualTo(Arrays.asList("pobi", "honux"));
    }

    @DisplayName("인자로 넣은 게임 실행 결과 정보를 반환")
    @Test
    void getPrizeNames() {
        assertThat(LadderShapeResult.of(playersAndPrizes, ladder)
                .getPrizeNames())
                .isEqualTo(Arrays.asList("3000", "꽝"));
    }

    // TODO 사다리 모양을 그리기 위한 계단 라인(한 행) 리스트(높이)를 반환
}
