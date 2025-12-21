package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LaddersTest {

    @Test
    void 사다리_전체_생성() {
        Ladders ladders = new Ladders(
                List.of(
                        new Ladder(0, 0, true),
                        new Ladder(1, 0, false),
                        new Ladder(2, 0, true),
                        new Ladder(0, 1, false),
                        new Ladder(1, 1, true),
                        new Ladder(2, 1, false)),
                2
        );

        assertThat(ladders.getLadders()).hasSize(6);
        assertThat(ladders.getHeight()).isEqualTo(2);
    }
}
