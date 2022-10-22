package ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @Test
    public void 사다리_다리_생성_가로_겹침_오류_검증() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"false:false", "true:false"}, delimiter = ':')
    public void 사다리_생성_가능_검증(boolean left, boolean right) {
        Direction direction = new Direction(left, right);
        assertThat(direction.isConnectableNext()).isTrue();
    }

    @Test
    public void 사다리_생성_불가능_검증() {
        Direction direction = new Direction(false, true);
        assertThat(direction.isConnectableNext()).isFalse();
    }

    @Test
    public void 이전에_다리가_있는_경우_검증() {
        Direction direction = new Direction(false, true);
        Direction result = direction.next();
        assertThat(result).isEqualTo(new Direction(true, false));
    }

    @Test
    public void 이전에_다리가_는_경우_검증() {
        Direction direction = new Direction(true, false);
        Direction result = direction.next();
        assertThat(result).isEqualTo(new Direction(false, false));
    }

}