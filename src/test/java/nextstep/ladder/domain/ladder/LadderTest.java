package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void create() {
        assertThatCode(() -> new Ladder(Height.of(5), 3, new DirectionRandomPredicate())).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리 생성 에외 테스트 - 위치가 2보다 작으면 예외가 발생한다.")
    void exception() {
        List<Position> positions = Arrays.asList(new Position(0, Direction.LEFT));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(Height.of(5), 1, new DirectionRandomPredicate()));
    }

}
