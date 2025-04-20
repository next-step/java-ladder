package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RungTest {

    @Test
    @DisplayName("첫번 째 사다리 가로대를 생성한다.")
    void createFirstRung() {
        assertThat(Rung.create(() -> true)).isEqualTo(new Rung(true));
        assertThat(Rung.create(() -> false)).isEqualTo(new Rung(false));
    }

    @Test
    @DisplayName("이전 사다리 가로대가 없으면 정책에 따라서 생성한다.")
    void createNextWithNonPrevious() {
        assertThat(new Rung(true).createNext(() -> true)).isEqualTo(new Rung(false));
        assertThat(new Rung(true).createNext(() -> false)).isEqualTo(new Rung(false));
        assertThat(new Rung(false).createNext(() -> true)).isEqualTo(new Rung(true));
        assertThat(new Rung(false).createNext(() -> false)).isEqualTo(new Rung(false));
    }

    @Test
    @DisplayName("사다리 가로대가 연결되어있는지 확인한다.")
    void isConnected() {
        assertTrue(new Rung(true).isConnected());
        assertFalse(new Rung(false).isConnected());
    }
}
