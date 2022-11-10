package nextstep.ladder;

import nextstep.ladder.domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("쉼표로 구분해 사람을 생성한다")
    void splitComma() {
        String names = "pobi,honux,crong,jk";
        Ladder ladder = new Ladder(5, names);
        assertThat(ladder.getUsers()).hasSize(4);
    }

    @Test
    @DisplayName("최대 높이 수로 사다리를 생성한다")
    void line() {
        String names = "pobi,honux,crong,jk";
        Ladder ladder = new Ladder(5, names);
        ladder.printLadder();
        assertThat(ladder.getLines()).hasSize(5);
    }
}
