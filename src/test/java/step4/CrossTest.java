package step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrossTest {
    @Test
    public void init() {
        assertThat(Cross.of(true, false)).isEqualTo(Cross.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatThrownBy(() -> {
            Cross.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 타기 첫번째 lane에서 이동가지가 오른쪽에 존재한다면, 이동할 방향은 오른쪽이다.")
    @Test
    public void first() {
        Direction first = Cross.first(true);
        assertThat(first).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("사다리 타기 첫번째 lane에서 이동가지가 존재하지 않는다면, 이동할 방향은 아래쪽이다.")
    @Test
    public void first2() {
        Direction first = Cross.first(false);
        assertThat(first).isEqualTo(Direction.DOWN);
    }


}
