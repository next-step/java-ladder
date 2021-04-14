package nextstep.ladder;

import nextstep.model.Ladder;
import nextstep.model.OnlineLadder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineLadderTest {
    @Test
    @DisplayName("사다리그리기테스트")
    void ladderString() {
        Ladder ladder1 = new OnlineLadder(2, 2, new String[]{"bong", "big"});
        assertThat(ladder1.ladderString(0)).contains("-----");

        Ladder ladder2 = new OnlineLadder(2, 2, new String[]{"bong", "big"});
        assertThat(ladder2.ladderString(1)).contains("-----");

        Ladder ladder3 = new OnlineLadder(2, 2, new String[]{"bong", "big"});
        assertThat(ladder3.ladderString(0)).contains("-----");
        assertThat(ladder3.ladderString(1)).contains("-----");
    }
}
