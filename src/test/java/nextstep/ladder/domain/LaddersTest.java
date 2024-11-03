package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LaddersTest {

    @Test
    void 높이가_1미만이면_예외() {
        assertThatThrownBy(
                () -> new Ladders(2, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 참가자_경기_결과() {
        // 0        1        2
        //      true    false

        Ladders ladders = new Ladders(3, 1, index -> index == 0);

        assertAll(
                () -> assertThat(ladders.searchIndex(0)).isEqualTo(1),
                () -> assertThat(ladders.searchIndex(1)).isEqualTo(0),
                () -> assertThat(ladders.searchIndex(2)).isEqualTo(2)
        );

    }

}
