package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BooleanStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LaddersTest {

    @Test
    void 높이가_1미만이면_예외() {

        assertThatIllegalArgumentException().isThrownBy(
                () -> Ladders.of(2, 0)
        );

    }

    @Test
    void 참가자_경기_결과() {
        // 0        1        2
        //      true    false
        //      false   true

        List<Ladder> create = Arrays.asList(
                new Ladder(Arrays.asList(true, false)),
                new Ladder(Arrays.asList(false, true))
        );
        Ladders ladders = Ladders.of(create);

        assertAll(
                () -> assertThat(ladders.searchIndex(0)).isEqualTo(2),
                () -> assertThat(ladders.searchIndex(1)).isEqualTo(0),
                () -> assertThat(ladders.searchIndex(2)).isEqualTo(1)
        );

    }

}
