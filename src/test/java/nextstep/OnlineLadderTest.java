package nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineLadderTest {
    @Test
    @DisplayName("사다리그리기테스트")
    void ladderString() {
        Ladder ladder1 = new OnlineLadder(2, 2, new String[]{"bong", "big"});
        ladder1.lineMark(1, 2);
        assertThat(ladder1.ladderString(1)).isEqualTo("|     |     |-----|");

        Ladder ladder2 = new OnlineLadder(2, 2, new String[]{"bong", "big"});
        ladder2.lineMark(1, 1);
        assertThat(ladder2.ladderString(1)).isEqualTo("|     |-----|     |");

        Ladder ladder3 = new OnlineLadder(2, 2, new String[]{"bong", "big"});
        ladder3.lineMark(2, 1);
        assertThat(ladder3.ladderString(1)).isNotEqualTo("|     |-----|     |");
        assertThat(ladder3.ladderString(1)).isEqualTo("|     |-----|     |");
    }
}
