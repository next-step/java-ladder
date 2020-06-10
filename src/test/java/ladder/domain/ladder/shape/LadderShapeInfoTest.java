package ladder.domain.ladder.shape;

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

public class LadderShapeInfoTest {

    private Players players;
    private Prizes prizes;
    private Height height;

    @BeforeEach
    void setUp() {
        List<String> names = Arrays.asList("pobi", "honux");
        this.players = Players.of(names);

        List<String> prizeNames = Arrays.asList("3000", "꽝");
        this.prizes = Prizes.of(prizeNames);

        this.height = Height.of(5);
    }

    @DisplayName("LadderShapeInfo 생성")
    @Test
    void create() {
        assertThatCode(() -> LadderShapeInfo.valueOf(players, prizes, height))
                .doesNotThrowAnyException();
    }

    @DisplayName("LadderShapeInfo 생성 실패 : 게임 참여자가 null")
    @NullSource
    @ParameterizedTest
    void playerIsNull(final Players players) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo.valueOf(players, prizes, height));
    }

    @DisplayName("LadderShapeInfo 생성 실패 : 게임 실행 결과가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final Prizes prizes) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo.valueOf(players, prizes, height));
    }

    @DisplayName("LadderShapeInfo 생성 실패 : 사다리 높이가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final Height height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo.valueOf(players, prizes, height));
    }

    @DisplayName("LadderShapeInfo 생성 실패 : - 게임 참여자의 수와 게임 실행 결과의 수가 다른 경우")
    @Test
    void notEqualsCountWithPlayersAndPrizes() {
        List<String> names = Arrays.asList("pobi", "honux");
        List<String> prizeNames = Arrays.asList("3000", "꽝", "5000");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderShapeInfo.valueOf(
                        Players.of(names), Prizes.of(prizeNames), height));
    }

    @DisplayName("입력한 게임 참여자를 반환")
    @Test
    void getPlayers() {
        assertThat(LadderShapeInfo.valueOf(players, prizes, height).getPlayers().count())
                .isEqualTo(players.count());
    }

    @DisplayName("입력한 게임 결를 반환")
    @Test
    void getPrizes() {
        assertThat(LadderShapeInfo.valueOf(players, prizes, height).getPrizes())
                .isEqualTo(prizes);
    }

    @DisplayName("입력한 사다리의 높이를 반환")
    @Test
    void getHeight() {
        assertThat(LadderShapeInfo.valueOf(players, prizes, height).getHeight())
                .isEqualTo(height.getValue());
    }

    @DisplayName("사다리의 한 행에 있는 기둥의 수를 반환")
    @Test
    void getWidth() {
        assertThat(LadderShapeInfo.valueOf(players, prizes, height).getWidth().getValue())
                .isEqualTo(players.count());
    }
}
