package ladder.domain;

import ladder.domain.fake.FakeThreeByOneLeftLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StairsTest {
    @DisplayName("여러 계단을 가진 일급 객체를 생성할 수 있다.")
    @Test
    void create() {
        int count = 3;
        Stairs stairs = new Stairs(new FakeThreeByOneLeftLineGenerator().generate(count));

        assertThat(stairs.count()).isEqualTo(3);
    }
}