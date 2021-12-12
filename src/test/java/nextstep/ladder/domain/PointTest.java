package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        Point point = new Point(false);

        assertThat(point).isNotNull();
    }
}
