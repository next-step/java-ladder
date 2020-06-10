package ladder.domain.dto;

import ladder.domain.PlayersAndPrizes;
import ladder.domain.ladder.Ladder2;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo2;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderShapeResult2Test {

    private PlayersAndPrizes playersAndPrizes;
    private Ladder2 ladder;

    @BeforeEach
    void setUp() {
        Players players = Players.of(Arrays.asList("pobi", "honux"));
        Prizes prizes = Prizes.of(Arrays.asList("3000", "꽝"));
        this.playersAndPrizes = PlayersAndPrizes.valueOf(players, prizes);

        this.ladder = Ladder2.of(
                LadderShapeInfo2.valueOf(playersAndPrizes, Height.of(5)));
    }

    @DisplayName("게임 참여자 이름과 사다리 판의 정보를 가진 LadderShapeResult 를 반환")
    @Test
    void create() {
        assertThatCode(() -> LadderShapeResult2.of(playersAndPrizes, ladder))
                .doesNotThrowAnyException();
    }

    @DisplayName("인자로 넣은 게임 참여자의 정보를 반환")
    @Test
    void getPlayerNames() {
        assertThat(LadderShapeResult2.of(playersAndPrizes, ladder)
                .getPlayerNames())
                .isEqualTo(Arrays.asList("pobi", "honux"));
    }

    @DisplayName("인자로 넣은 게임 실행 결과 정보를 반환")
    @Test
    void getPrizeNames() {
        assertThat(LadderShapeResult2.of(playersAndPrizes, ladder)
                .getPrizeNames())
                .isEqualTo(Arrays.asList("3000", "꽝"));
    }

    // TODO 사다리 모양을 그리기 위한 계단 라인(한 행) 리스트(높이)를 반환
}
