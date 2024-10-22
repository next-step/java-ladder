package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewordTest {

    public static final Reword r1 = new Reword("5000");
    public static final Reword r2 = new Reword("3000");

    @Test
    @DisplayName("생성자로 리워드를 생성한다.")
    void 리워드_생성() {
        assertThat(r1.getReword()).isEqualTo("5000");
    }
}
