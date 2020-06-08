package ladder.domain.ladder;

import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    private Players players;
    private Prizes prizes;

    @BeforeEach
    void setUp() {
        List<String> names = new ArrayList<>();
        names.add("pobi");

        this.players = Players.of(names);
        this.prizes = Prizes.of(names);
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
        assertThatCode(() -> Ladder.of(
                LadderShapeInfo.valueOf(players, prizes, Height.of(Height.MIN_HEIGHT))))
                .doesNotThrowAnyException();
    }
}
