package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("Point 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        boolean inputBoolean = true;

        // when
        Point point = Point.of(inputBoolean);

        // then
        assertThat(point).isNotNull();
    }

}