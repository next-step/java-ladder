package ladder.domain.ladder;

import ladder.domain.player.LadderPlayers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinesCreatorTest {

    private String[] playerNames;

    @BeforeEach
    void init() {
        this.playerNames = new String[]{"pobi", "honux", "po", "bi"};
    }

    @Test
    @DisplayName("사다리 creator 만들기 테스트 높이값이 음수일 경우")
    void LadderCreator_높이값_음수일경우_Test() {
        assertThatThrownBy(() ->  LadderHeight.inputHeight(-1))
                .hasMessageMatching("높이는 1 보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("사다리가 정상적으로 만들어 지는지 테스트")
    void LadderCreator_성공_Test() {
        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        LadderHeight ladderHeight = LadderHeight.inputHeight(5);
        LineCount requestLineCount = ladderPlayers.getRequestLineCount();
        LadderCreator ladderCreator = LadderCreator.create(requestLineCount, ladderHeight);
        assertThat(ladderCreator).isNotNull();
    }
}
