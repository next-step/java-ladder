package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void create() {
        Ladder ladder = new Ladder(Height.from(5), 3, new DirectionRandomPredicate());
        assertThat(ladder.getLines()).hasSize(5);
        assertThat(ladder.getLines().get(0).getPositions()).isNotNull();
        assertThat(ladder.getHeight()).isEqualTo(5);
    }
}
