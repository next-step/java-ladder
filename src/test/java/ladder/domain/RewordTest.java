package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewordTest {

    @Test
    @DisplayName("생성자로 리워드를 생성한다.")
    void 리워드_생성() {
        assertThat(new Reword("4000").getReword()).isEqualTo("4000");
    }
}
