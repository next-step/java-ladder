package ladder.domain.ladder.shape;

import ladder.domain.ladder.Height;
import ladder.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderShapeInfoTest {

    private Players players;
    private Height height;

    @BeforeEach
    void setUp() {
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");

        this.players = Players.of(names);
        this.height = Height.of(5);
    }

    @DisplayName("LadderShapeInfo 생성")
    @Test
    void create() {
        assertThatCode(() -> LadderShapeInfo.valueOf(players, height))
                .doesNotThrowAnyException();
    }

    @DisplayName("LadderShapeInfo 생성 실패 : 게임 참여자가 null")
    @NullSource
    @ParameterizedTest
    void playerIsNull(final Players players) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo.valueOf(players, height));
    }

    @DisplayName("LadderShapeInfo 생성 실패 : 사다리 높이가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final Height height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo.valueOf(players, height));
    }

    @DisplayName("입력한 게임 참여자를 반환")
    @Test
    void getPlayers() {
        assertThat(LadderShapeInfo.valueOf(players, height).getPlayers().count())
                .isEqualTo(players.count());
    }

    @DisplayName("입력한 사다리의 높이를 반환")
    @Test
    void getHeight() {
        assertThat(LadderShapeInfo.valueOf(players, height).getHeight().getValue())
                .isEqualTo(height.getValue());
    }

    @DisplayName("사다리의 한 행에 있는 기둥의 수를 반환")
    @Test
    void getWidth() {
        assertThat(LadderShapeInfo.valueOf(players, height).getWidth().getValue())
                .isEqualTo(players.count());
    }
}
