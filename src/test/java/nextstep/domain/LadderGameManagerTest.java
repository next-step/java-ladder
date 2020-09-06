package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 게임 진행 객체")
public class LadderGameManagerTest {

    @DisplayName("생성")
    @Test
    public void create() {
        LadderGameManager ladderGameManager = new LadderGameManager(participants, LineFactory.createLines(5, 3));
        assertThat(ladderGameManager.getLines()).hasSize(3);
    }

    @DisplayName("트랙 번호 구하기")
    @Test
    public void getNextTrackNumber() {
        LadderGameManager ladderGameManager = new LadderGameManager(participants, LineFactory.createLines(5, 3, new SwitchDrawTransverseBarStrategy()));
        assertThat(ladderGameManager.getNextTrackNumber(0, 0)).isEqualTo(1);
        assertThat(ladderGameManager.getNextTrackNumber(0, 1)).isEqualTo(0);
        assertThat(ladderGameManager.getNextTrackNumber(0, 2)).isEqualTo(3);
        assertThat(ladderGameManager.getNextTrackNumber(0, 3)).isEqualTo(2);
        assertThat(ladderGameManager.getNextTrackNumber(0, 4)).isEqualTo(4);
    }

    @DisplayName("시작")
    @Test
    public void start() {
        LadderGameManager ladderGameManager = new LadderGameManager(participants, LineFactory.createLines(5, 3, new SwitchDrawTransverseBarStrategy()));
        assertThat(ladderGameManager.start(0)).isEqualTo(1);
        assertThat(ladderGameManager.start(1)).isEqualTo(0);
        assertThat(ladderGameManager.start(2)).isEqualTo(3);
        assertThat(ladderGameManager.start(3)).isEqualTo(2);
        assertThat(ladderGameManager.start(4)).isEqualTo(4);
    }

}
