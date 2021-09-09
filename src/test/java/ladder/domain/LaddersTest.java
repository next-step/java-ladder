package ladder.domain;

import ladder.util.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LaddersTest {

    private Ladders ladders;

    @BeforeEach
    void setup() {
        LadderWidth ladderWidth = new LadderWidth(4);
        LadderHeight ladderHeight = new LadderHeight(3);
        ladders = Ladders.initLadders(ladderWidth, ladderHeight, () -> Direction.RIGHT);
    }

    @DisplayName("initLadders 높이 확인")
    @Test
    void initLadders_ReturnInputHeight() {
        assertThat(ladders.getLadderHeight()).isEqualTo(new LadderHeight(3));
    }

    @DisplayName("initLadders 가로 너비 확인")
    @Test
    void initLadders_ReturnInputWidth() {
        assertThat(ladders.getLadderWidth()).isEqualTo(new LadderWidth(4));
    }

    @DisplayName("플레이어 수와 사다리 넓이 길이가 다를 경우 IllegalArgumentException 발생")
    @Test
    void play_ThrowsIllegalArgumentException_IfPlayersSizeAndLadderWidthAreDifferent() {
        Players players = new Players(StringUtil.split("risa, jisu, rose"));
        PlayResults playResults = new PlayResults(StringUtil.split("꽝, 5000원, 10000원"));
        assertThatIllegalArgumentException().isThrownBy(
                () -> ladders.play(players, playResults)
        );
    }

    @DisplayName("플레이어 수와 플레이결과 수가 다를 경우 IllegalArgumentException 발생")
    @Test
    void play_ThrowsIllegalArgumentException_IfPlayersSizeAndPlayResultsSizeAreDifferent() {
        Players players = new Players(StringUtil.split("risa, jisu, rose, zeny"));
        PlayResults playResults = new PlayResults(StringUtil.split("꽝, 5000원, 10000원"));
        assertThatIllegalArgumentException().isThrownBy(
                () -> ladders.play(players, playResults)
        );
    }

    @DisplayName("사다리게임 플레이")
    @Test
    void play() {
        Players players = new Players(StringUtil.split("risa,jisu,rose,zeny"));
        PlayResults playResults = new PlayResults(StringUtil.split("꽝,5000원,꽝,10000원"));
        ladders.play(players, playResults);
        Player expected = new Player("risa");
        expected.report(new PlayResult("5000원"));

        assertThat(players.find(new Name("risa"))).isEqualTo(expected);
    }
}