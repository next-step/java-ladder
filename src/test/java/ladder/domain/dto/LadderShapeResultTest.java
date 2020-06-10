package ladder.domain.dto;

import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderShapeResultTest {

    private List<String> names;
    private List<String> prizeNames;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        this.names = Arrays.asList("pobi", "honux");
        this.prizeNames = Arrays.asList("3000", "꽝");

        this.ladder = Ladder.of(
                LadderShapeInfo.valueOf(Players.of(names), Prizes.of(prizeNames), Height.of(5)));
    }

    @DisplayName("게임 참여자 이름과 사다리 판의 정보를 가진 LadderShapeResult 를 반환")
    @Test
    void create() {
        assertThatCode(() -> LadderShapeResult.of(names, prizeNames, ladder))
                .doesNotThrowAnyException();
    }

    @DisplayName("인자로 넣은 게임 참여자의 정보를 반환")
    @Test
    void getPlayerNames() {
        assertThat(LadderShapeResult.of(names, prizeNames, ladder)
                .getPlayerNames())
                .isEqualTo(names);
    }

    @DisplayName("인자로 넣은 게임 실행 결과 정보를 반환")
    @Test
    void getPrizeNames() {
        assertThat(LadderShapeResult.of(names, prizeNames, ladder)
                .getPrizeNames())
                .isEqualTo(prizeNames);
    }
}
