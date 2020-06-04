package ladder.domain.ladder;

import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    private Players players;

    @BeforeEach
    void setUp() {
        List<String> names = new ArrayList<>();
        names.add("pobi");

        this.players = Players.of(names);
    }

    @DisplayName("사다리 생성 실패: 사다리의 높이와 기둥의 개수는 최소 1개 이상")
    @ParameterizedTest
    @CsvSource({ "1,0", "0,1", "0,0" })
    void createFailure(final int height, final int playerCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(Height.of(height), playerCount));
    }

    @DisplayName("Ladder 생성")
    @Test
    void create() {
        assertThatCode(() -> Ladder.of(Height.of(Height.MIN_HEIGHT), PillarCount.MIN_COUNT))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 생성 실패: 사다리의 높이가 1보다 작은 경우")
    @Test
    void createFailureByHeightLessThanMin() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(LadderShapeInfo.valueOf(players, Height.of(Height.MIN_HEIGHT - 1))));
    }

    @DisplayName("사다리 생성 실패: 참여자의 수 1보다 작은 경우")
    @Test
    void createFailureByPlayersLessThanMin() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(LadderShapeInfo.valueOf(Players.of(new ArrayList<>()), Height.of(Height.MIN_HEIGHT))));
    }

    @DisplayName("Ladder 생성")
    @Test
    void create2() {
        assertThatCode(() -> Ladder.of(LadderShapeInfo.valueOf(players, Height.of(Height.MIN_HEIGHT))))
                .doesNotThrowAnyException();
    }
}
