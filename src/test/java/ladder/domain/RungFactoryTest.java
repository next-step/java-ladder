package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RungFactoryTest {

    @Test
    @DisplayName("다음 사다리 가로대를 생성한다.")
    void createNextRung() {
        RungFactory factory = new RungFactory(() -> true);
        assertThat(factory.createNextRung()).isEqualTo(new Rung(true));
    }
}
