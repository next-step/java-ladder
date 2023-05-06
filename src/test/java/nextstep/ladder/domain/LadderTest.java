package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("Ladder 높이와 사람 수를 가지고 생성한다.")
    void test01() {
        Ladder ladder = new Ladder(5, 4);

        assertThat(ladder.lines()).hasSize(4);
    }

    @Test
    @DisplayName("사다리의 마지막 위치를 가져온다.")
    void test02() {
        Ladder ladder = new Ladder(List.of(new Line(false, true, false),
                                           new Line(false, true, false)));

        assertThat(ladder.move(0)).isEqualTo(0);
        assertThat(ladder.move(1)).isEqualTo(1);
        assertThat(ladder.move(2)).isEqualTo(2);
    }
}
