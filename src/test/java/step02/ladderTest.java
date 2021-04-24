package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.ladder.Ladder;
import step02.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class ladderTest {

    @Test
    @DisplayName("입력한 사람 수, 사다리 높이 만큼 사다리가 만들어졌는지 확인")
    void createLadder() throws IllegalAccessException {
        Ladder ladder = new Ladder(5, 4);
        assertThat(ladder.getYLineCount()).isEqualTo(4);
        assertThat(ladder.getXLineCount()).isEqualTo(5);
        ResultView.showLadder(ladder);
    }
}
