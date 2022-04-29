package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("라인")
class LineTest {

    @Test
    @DisplayName("포인터들로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Line.from(Collections.singletonList(Point.connected())));
        assertThatNoException().isThrownBy(() -> Line.from(Arrays.asList(Point.connected(), Point.disconnected(), Point.connected())));
    }

    @Test
    @DisplayName("포인터들은 필수")
    void instance_nullOrEmpty_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.from(null));
        assertThatIllegalArgumentException().isThrownBy(() -> Line.from(Collections.emptyList()));
    }

    @Test
    @DisplayName("연결된 포인터들이 연속적으로 존재할 수 없음")
    void instance_continuouslyConnected_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.from(Arrays.asList(Point.disconnected(), Point.connected(), Point.connected())));
    }
}
