package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EdgeTest {

    @Test
    @DisplayName("Point 생성 결과 테스트")
    void line() {
        Edge edge = new Edge();

        assertThat(edge.next(()->true))
                .isEqualTo(new Edge(true));
        assertThat(edge.next(()->false))
                .isEqualTo(new Edge(false));
    }
}