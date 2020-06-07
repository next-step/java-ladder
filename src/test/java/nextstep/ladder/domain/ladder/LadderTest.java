package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void create() {
        Ladder ladder = new Ladder(Height.of(5), 3, new DirectionRandomPredicate());
        assertThat(ladder.getLines()).hasSize(5);
        assertThat(ladder.getLines().get(0).getPositions()).hasSize(3);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 생성 에외 테스트 - 위치가 2보다 작으면 예외가 발생한다.")
    void exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(Height.of(5), 1, new DirectionRandomPredicate()));
    }

}
