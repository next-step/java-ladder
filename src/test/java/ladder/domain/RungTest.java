package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RungTest {

    @Test
    @DisplayName("이전 사다리 가로대가 없으면 정책에 따라서 생성한다.")
    void createWithNonPrevious() {
        assertThat(Rung.create(() -> true, null)).isEqualTo(new Rung(true));
        assertThat(Rung.create(() -> true, new Rung(false))).isEqualTo(new Rung(true));
        assertThat(Rung.create(() -> false, null)).isEqualTo(new Rung(false));
        assertThat(Rung.create(() -> false, new Rung(false))).isEqualTo(new Rung(false));
    }

    @Test
    @DisplayName("이전 사다리 가로대가 있으면 정책에 따라서 생성한다.")
    void createWithPrevious() {
        assertThat(Rung.create(() -> true, new Rung(true))).isEqualTo(new Rung(false));
        assertThat(Rung.create(() -> false, new Rung(true))).isEqualTo(new Rung(false));
    }

    @Test
    @DisplayName("사다리 가로대가 연결되어있는지 확인한다.")
    void isConnected() {
        assertTrue(new Rung(true).isConnected());
        assertFalse(new Rung(false).isConnected());
    }
}
