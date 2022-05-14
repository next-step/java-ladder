package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PartsTest {

    private Parts parts;
    private final int length = 5;

    @BeforeEach
    void setUp() {
        parts = new Parts(length);
    }

    @Test
    void createTest() {
        parts = new Parts(1);

        assertThat(parts).isNotNull();
        assertThat(parts.size()).isEqualTo(1);
    }

    @DisplayName("세로줄 파트에서 연결하려고 하면 실패한다.")
    @Test
    void connectTest1() {
        assertThatThrownBy(() -> parts.connectPart(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위에 맞지 않는 파트 인덱스 연결은 실패한다.")
    @Test
    void connectTest2() {
        assertThatThrownBy(() -> parts.connectPart(-1))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> parts.connectPart(5))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가로줄 파트에서 연결 성공한다.")
    @Test
    void connectTest3() {
        parts.connectPart(1);

        assertThat(parts.isConnected(0)).isTrue();
        assertThat(parts.isConnected(1)).isTrue();
        assertThat(parts.isConnected(2)).isTrue();
    }

}